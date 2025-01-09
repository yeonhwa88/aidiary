from flask import Flask, render_template, request
from models import Member
from filters import mask_password, mask_password

app = Flask(__name__)
app.template_filter('mask_password')(mask_password) # ()앞은 필터이름 ()뒤는 함수이름

# 필터 파일은 filters.py로 옮김
# @ app.template_filter('mask_password')
# def mask_password(password):
#     return '*'*len(password)

@app.route('/user') # /user?name=hong
def user():
    name = request.args.get('name') # get방식 파라미터 값 받기
    return "<h1>User Name = " +  name + "</h1>"

@app.route('/')
def index():
    return render_template("join_get/index.html")

@app.route('/join_form')
def join_from():
    return render_template("join_get/join.html")

@app.route('/join')
def join():
    name = request.args.get("name") # get방식일때 사용
    id   = request.args.get("id")
    pw   = request.args.get("pw")
    addr = request.args.get("addr")
    member = Member(name, id, pw, addr)
    return render_template("join_get/result.html",
                           member=member)
@app.route("/welcome")
def welcome():
    name = request.args.get("name") # get방식으로 받은 파라미터 값
    value = request.args.get("value")
    return render_template("welcome.html",
                           name=name,
                           value=value)

if __name__=="__main__":
    app.run(debug=True)
# flask run --reload 서버 강제 실행 위에 코드없이 실행
# app_get.py 파일일 경우 터미널에서 flask run --reload입력시 app.py파일 자동 실행
    # py 파일이 변경될 때마다 서버 자동 재시작
    # templates나 static 파일이 변경될 때 서버 자동 재시작이 안 되기도 함