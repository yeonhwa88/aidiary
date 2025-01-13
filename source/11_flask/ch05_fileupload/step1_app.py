from flask import Flask, render_template, request
from werkzeug.utils import secure_filename
# 서버에 영향을 미칠수 있는 특수문자의 파일 이름을 문제가 없게 _ 변경해주는 import
import os
# 업로드 폴더 경로 설정(폴더없으면 폴더생성)
UPLOAD_FOLDER='./upload/'
if not os.path.exists(UPLOAD_FOLDER):
    os.makedirs(UPLOAD_FOLDER)

app = Flask(__name__)
# 파일 업로드 용량 제한(단위:바이트)
# 용량 제한이 없을 경우, 서버에서 매우 큰 용량을 업로드 할 경우 403 에러발생
app.config['MAX_CONTENT_LENGTH'] = 1024*1024*10 # 최대 업로드 용량

@app.route('/', methods=['GET','POST'])
def upload_file():
    # 파일업로드는 post 방식으로 
    if request.method == 'POST': # 반드시 대문자
        ''' 
        파라미터로 전달받은 파일을 upload 폴더에 저장하고 완료 페이지로 가기
        '''
        f = request.files['file']
        # 파일명이 서버에 영향을 미칠 문자가 포함된 경우 _로 교체
        save_filename = secure_filename(f.filename)
        f.save(UPLOAD_FOLDER + save_filename) # 파일 저장 UPLOAD_FOLDER 상단에 경로 설정 해둔 변수
        return render_template('check.html')
    return render_template('upload.html')

if __name__ == "__main__":
    app.run(debug=True) # 서버 실행

