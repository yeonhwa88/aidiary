from django.db import models
from django import forms
from django.core.validators import MinLengthValidator # 만들어진 함수 글자 수 에러
from django.core.validators import MinValueValidator # 얼마 1원 이상
from django.core.validators import MaxValueValidator # 얼마 100만원 까지
from django.urls import reverse


def min_length_3_validator(value):
    if len(value)<3:
        raise forms.ValidationError('3글자 이상의 저자이름을 입력하세요')

class Book(models.Model):
    title = models.CharField(verbose_name="책제목", max_length=50)
    author = models.CharField(verbose_name="저자",
                              max_length=50,
                              validators=[MinLengthValidator(3) ])
    publisher = models.CharField(verbose_name=" 출판사", max_length=50, blank=True, null=True)
    publication_date = models.DateField(auto_now_add=True)
    sales = models.IntegerField(verbose_name="판매가",default=1000,
                                validators=[MinValueValidator(0),
                                            MaxValueValidator(1000000)])
    ip = models.GenericIPAddressField(blank=True, null=True) # ip주소 자동저장

    def __str__(self):
        return "{}:{}著 {:,}원 from{}".format(self.title,
                                             self.author,
                                             self.sales,
                                             self.ip)
    def get_absolute_url(self):
        return reverse('book:list')
        return reverse('book:list', args=[self.id])
    class Meta:
        ordering = ["-publication_date"] # 최근 입력된 순서부터 출력 orderby
        unique_together = (('title','author'), ) # title과 author가 두개가 똑같으면 저장이 안되고 하나만 중복되는건 저장이 가능