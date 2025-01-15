# 파일 첨부 화면(home.html) : form태그 + upload에 첨부된 파일 list(파일 다운로드, 파일 삭제)
from Tools.scripts.win_add2path import modify
from flask import Flask, render_template
from flask import send_file  # 다운로드시 필요S
from flask import redirect, url_for  # 삭제 후 '/'요청경로로 redirect 하기 위함
from flask_wtf import FlaskForm
from flask_wtf.file import FileField, FileRequired
from werkzeug.utils import secure_filename

import os
import datetime

app = Flask(__name__)
print(app.config)
app.config['SECRET_KEY'] = 'secret'

class FileForm(FlaskForm):
    files = FileField(validators=[FileRequired()])

def stamp2real(stamp):
    return datetime.datetime.fromtimestamp(stamp)

def info(filename):
    create = stamp2real(os.path.getctime(filename))
    modify = stamp2real(os.path.getmtime(filename))
    access = stamp2real(os.path.getatime(filename))
    tempsize = os.path.getsize(filename)
    size = ''
    if tempsize < 1024*1024:
        size = '{:.3f}KB'.format(tempsize/1024)
    else:
        size = '{:.3f}MB'.format(tempsize/(1024*1024))
    return create, modify, access, size

@app.route('/', methods=['GET', 'POST'])
def main_page():
    form = FileForm()
    if form.validate_on_submit():  # POST방식으로 유효한 form 데이터가 들어왔는지 여부:True
        f = form.files.data
        filepath = './upload/' + secure_filename(f.filename)
        f.save(filepath)
        create, modify, access, size = info(filepath)
        fileinfo = {'ctime':create, 'modify':modify, 'access':access, 'size':size}
        return render_template('check.html', fileinfo=fileinfo)
    # GET방식이거나 form 데이터가 유효하지 않은 경우
    # upload 폴더의 파일 정보들을 home.html로 render
    filelist = os.listdir('./upload/')
    # print(['upload/'+ filename for filename in filelist])
    infos = []
    for filename in filelist:
        create, modify, access, size = info('./upload/'+filename)
        fileinfo = {
            'name':filename,
            'create':create,
            'modify':modify,
            'size':size
        }
        infos.append(fileinfo)
    return render_template('home.html',
                           form=form,
                           infos=infos)

@app.route('/download/<filename>')
def download_file(filename):
    return send_file('upload/'+filename,
                     as_attachment=True) # 파일이 브라우저에서 열리지 않고 다운로드만 진행

@app.route('/del/<filename>')
def del_file(filename):
    os.remove('upload/'+filename)
    # return redirect(url_for('main_page')) # url을 만들어줘서 main_page로 다시 실행 = '/' 요청경로
    return redirect('/')

if __name__ == '__main__':
    app.run(debug=True)