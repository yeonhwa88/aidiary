# Rendering
# html로 보내기
from flask import Flask, render_template, url_for

app = Flask(__name__)

@app.route('/')
def hello():
    return render_template("05_index.html") # 대소문자 구분 # html 파일 생성

@app.route('/profile/<name>/<int:age>') #/profile/홍길동/33
def get_profile(name, age):
    return render_template("05_profile.html",
                           name=name,
                           age=age)

if __name__ == '__main__':
    with app.test_request_context():
        print('※', url_for('hello'))
        print('※', url_for('get_profile', name='Hong', age=22))
    app.run(debug = True)
# html 경로 올바르지 않을 때 TemplateNotFound 에러