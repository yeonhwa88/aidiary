from django.shortcuts import render, redirect, get_object_or_404

from .forms import BookForm, BookModelForm
from .models import Book
from django.views.generic import ListView
from django.views.generic import CreateView
from django.views.generic import UpdateView
from django.views.generic import DeleteView

book_list = ListView.as_view(model=Book) # 함수를 return

# def book_list(request):
#     return render(request,
#                   "book/book_list.html",
#                   {'book_list':Book.objects.all()})

book_new = CreateView.as_view(model=Book,
                              fields=['title', 'author', 'publisher', 'sales'])

# def book_new(request):
#     if request.method == "POST" :
#         #request.POST의 파라미터 값을 book 객체로 만든 후 save()
#         form = BookModelForm(request.POST, request.FILES) # FILES file이 넘어왔을때 사용
#         if form.is_valid():
#             # book = Book(**form.cleaned_data) # 딕셔너리 형태, 입력받은 파라미터만 들어감
#             book = form.save(commit=False) # 위와 동일
#             book.ip = request.META['REMOTE_ADDR'] # 요청한 client의 ip
#             book.save()
#             # return redirect('book:list')
#             return redirect(book) # book.get_absolute_url 자동호출
#     else :
#         # form = BookForm()
#         form = BookModelForm()
#     return render(request,
#                   'book/book_form.html',
#                   {'form':form})

def book_edit(request, pk):
    book = get_object_or_404(Book, pk=pk)
    print('수정될 책 정보', book)
    if request.method == 'POST':
        # 파라미터정보를 form객체로 받아 유효성 체크 (1)성공 save (2)실패시 form태그페이지
        form = BookModelForm(request.POST, instance=book)
        if form.is_valid():
            book = form.save(commit=False)
            # book.ip = request.META['REMOTE_ADDR'] # 수정한 ip 덮어 쓰기
            book.save()
            return redirect(book)
    else:
        form = BookModelForm(instance=book)
        return render(request,
                      'book/book_form.html',
                      {'form':form})

def book_delete(request, pk):
    book = get_object_or_404(Book, pk=pk)
    if request.method == 'POST':
        book.delete()
        return redirect(book)
    else:
        return render(request,
               'book/book_confirm_delete.html',
               {'object':book})