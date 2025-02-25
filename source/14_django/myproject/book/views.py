from django.shortcuts import render, redirect

from .forms import BookForm, BookModelForm
from .models import Book
from django.views.generic import ListView
from django.views.generic import CreateView
from django.views.generic import UpdateView
from django.views.generic import DeleteView

book_list = ListView.as_view(model=Book)

# def book_list(request):
#     return render(request,
#                   "book/book_list.html",
#                   {'book_list':Book.objects.all()})

def book_new(request):
    if request.method == "POST" :
        #request.POST의 파라미터 값을 book 객체로 만든 후 save()
        form = BookModelForm(request.POST, request.FILES) # FILES file이 넘어왔을때 사용
        if form.is_valid():
            book = Book(**form.cleaned_data) # 딕셔너리 형태, 입력받은 파라미터만 들어감
            book.ip = request.META['REMOTE_ADDR'] # 요청한 client의 ip
            book.save()
            return redirect('book:list')
    else :
        # form = BookForm()
        form = BookModelForm()
    return render(request,
                  'book/book_form.html',
                  {'form':form})

def book_edit(request):
    pass

def book_delete(request):
    pass