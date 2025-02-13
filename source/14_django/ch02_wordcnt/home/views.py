from django.shortcuts import render
from django.http import HttpResponse, HttpRequest

# Create your views here.
def index(request):
    context = {'msg':'wordCount Welcome Page',
               'greeting':'Hello, Django(장고)'}
    return render(request=request,
                  template_name='home/index.html',
                  context=context)

def test(request):
    return HttpResponse(''' <h1> test page </h1>
                            <button onclick="location='/'"> 뒤로가기 </button>
    ''')

def showIntId(request:HttpRequest, id:int):
    msg = "숫자 ID는 " + str(id)
    id_type = "숫자 입니다"
    return render(request,
                  'home/showId.html',
                  {'msg':msg,
                   'type':id_type})

def showStrId(request, id):
    msg = '문자  ID는' + id
    id_type = '문자입니다'
    return render(request,
                   'home/showId.html',
                   {'msg':msg,
                    'type':id_type})