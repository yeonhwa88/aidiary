# src -> 소스 루트 설정
# pip install fastapi
# pip install uvicorn --no-cache-dir
# pip install jinja2
# pip install python-multipart

# 실행 시 cd src 입력 후 src 경로로 들어가서 uvicorn 실행

from fastapi import FastAPI
from fastapi import Request # template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import  StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse # redirect 요청경로를 다시 수행
# from pydantic import BaseModel # 자동 타입 체크
from models import ToDoRequest
from fastapi import Form # create(POST방식)
from fastapi import HTTPException # 예외코드 지정
import os

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__)) # 현 폴더의 절대경로
app.mount('/static',
          StaticFiles(directory=os.path.join(BASE_DIR,'../static')),
          name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR,
                                                   '../templates'))



todo_data = {
    1:{
        'id':1,
        'contents':'딥러닝 공부',
        'is_done':True
    },
    2:{
        'id':2,
        'contents':'fastAPI 공부',
        'is_done':False
    },
    3:{
        'id':3,
        'contents':'머신러닝 공부',
        'is_done':False
    },
    4:{
        'id':4,
        'contents':'Django 공부',
        'is_done':False
    }
}
@app.get('/')
# async def health_check_handler():
#     return {'status':'ok'}
# /todos(할일 1부터 출력) 또는 /todos?order=desc(할일 역순으로 출력)
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request,order:str|None=None):
    todos = list(todo_data.values()) # 딕셔너리를 리스트로 변환
    if order and order.upper()=='DESC':
        todos = todos[::-1]
    next_id = max(todo_data.keys())+1 # key값만 가져오기
    return templates.TemplateResponse('todos.html', # todo 목록, todo 입력 form
                                      {'request':request,
                                       'todos':todos,
                                       'next_id':next_id,
                                       'order':order.upper() if order else ''} )
@app.get('/todos/{todo_id}')
async def get_todo_detail_handler(request:Request, todo_id:int):
    todo = todo_data.get(todo_id, {}) # todo_data[todo_id] # 3을 입력시 3번 아이디를 반환 없는 번호가 들어왔을시 오류 없는 번호 입력시 None 반환
    return templates.TemplateResponse('todo.html',
                                      {'request':request,
                                        'todo':todo})

@app.post('/create')
async def create_todo_handler(todo:ToDoRequest=Form()):
    # print('form태그로 부터 입력된 todo',todo)
    todo_data[todo.id] = todo.dict()
    # {'id': todo.id, 'contents':todo.contents, 'is_done':todo.is_done} dict가 없어지면 만들어서 사용
    return RedirectResponse('/todos')

@app.delete('/delete/{todo_id}')
async def delete_todo_handler(todo_id:int):
    # del todo_data[todo_id]
    # key가 없는 todo_id를 입력할 경우 None

    todo = todo_data.pop(todo_id, None)
    if todo:
        return f'{todo_id}번 todo 삭제 성공'
    return f'{todo_id}번은 등록되지 않은 todo 삭제 실패'