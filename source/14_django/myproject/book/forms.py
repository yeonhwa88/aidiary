from django import forms
from django.core.validators import MinLengthValidator # 만들어진 함수 글자 수 에러
from django.core.validators import MinValueValidator # 얼마 1원 이상
from django.core.validators import MaxValueValidator # 얼마 100만원 까지
from .models import Book

class BookForm(forms.Form):
    title = forms.CharField(label = '책제목')
    author = forms.CharField(label = '글쓴이', validators=[MinLengthValidator(3)])
    publisher = forms.CharField(label = '출판사', required=False)
    sales = forms.IntegerField(initial=1000,
                               validators=[MinValueValidator(0),
                                           MaxValueValidator(1000000)])

    def save(self, commit=True):
        book = Book(**self.cleaned_data)
        if commit:
            book.save()
        return book

# 모델에서 참조하여 생성
class BookModelForm(forms.ModelForm): # ModelForm안에 save() 있음
    class Meta:
        model = Book
        fields = ['title', 'author', 'publisher', 'sales']
        # fields = '__all__'