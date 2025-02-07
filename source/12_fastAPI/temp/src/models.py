# fastAPI에서 post방식 요청파라미터 보낼 때 타입 검증
from pydantic import BaseModel

class ToDoRequest(BaseModel):
    content : str | None=''
    is_done : bool | None=False