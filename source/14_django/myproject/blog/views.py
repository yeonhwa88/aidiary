from http.client import responses

from django.http import HttpResponse, Http404, JsonResponse
from django.shortcuts import render, get_object_or_404
from .models import Post
import pandas as pd
from io import StringIO, BytesIO # str버퍼, 바이너리데이터버퍼
from urllib.parse import quote

# Create your views here.
def index(request):
    post_list = Post.objects.all()
    # output = '<br>'.join([post.__str__() for post in post_list])
    # print(output)
    # return HttpResponse("<h1>Welcome Page<h1>"+ output)
    return render(request,
                  'blog/index.html',
                  {'post_list':post_list})

def detail(request, post_id):
    # try:
    #     post = Post.objects.get(pk=post_id)
    # except Post.DoesNotExist:
    #     raise Http404("Post does not exist")
    post = get_object_or_404(Post, pk=post_id) # 예외처리 쉽게 하는법
    # return HttpResponse("post_id " + post.__str__())
    return render(request,
                  'blog/detail.html',
                  {'post':post})

def json_test(request):
    data = {
        'name':'hong',
        'age':22,
        'address':'서울시 관악구'
    }
    return JsonResponse(data,
                        json_dumps_params={ # 한글 깨짐 방지
                            'ensure_ascii':False
                        })

def excel_download(request):
    filename = "myproject.xlsx"
    with open(filename, 'rb') as f:
        # response = HttpResponse(f, content_type='text/html; charset=utf-8') 기본값
        response = HttpResponse(f, content_type='application/vnd.ms-excel')
        response['Content-Disposition']="attachment; filename={}".format(filename) # 다운받을 file이름
        return response

def pandas_csv_download(request):
    df = pd.DataFrame([
        [100,90,80],
        [100,99,88],
        [99,91,97],
    ], columns=['하나', '둘', '셋'])
    io = StringIO() # str 버퍼
    df.to_csv(io, index=None) # 메모리 버퍼에 저장
    io.seek(0) # 첫번째를 가르킴
    filename=quote('pandas_csv.csv')
    response = HttpResponse(io, content_type='text/csv')
    response['Content-Disposition'] = "attachment; filename={}".format(filename)
    return response

def pandas_excel_download(request):
    df = pd.DataFrame([
        [100, 90, 80],
        [100, 99, 88],
        [99, 91, 97],
    ], columns=['하나', '둘', '셋'])
    io = BytesIO()  # 바이너리 버퍼
    df.to_excel(io, index=None)  # 메모리 버퍼에 저장
    io.seek(0) # 첫번째를 가르킴
    filename = quote('pandas_csv.xlsx')
    response = HttpResponse(io, content_type='application/vnd.ms-excel')
    response['Content-Disposition'] = "attachment; filename={}".format(filename)
    return response