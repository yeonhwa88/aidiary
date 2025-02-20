from django.db import models
import re
from django.forms import ValidationError

REGION_CHOICE = (
  ("Europe","유럽"),
  ("Asia","아시아"),
  ("Africa","아프리카"),
  ("Oceania","오세아니아"),
  ("America","아메리카"),
)
def lnglat_valudator(value):
    if not re.match(r'(\d+\.?\d*),(\d+\.?\d*)', value):  # * 0번이상 있을수도 없을수도있기때문
        raise ValidationError('Invalid LngLat. ex:38,125')

class Post(models.Model): # 테이블명 :blog_post
    # id = models.AutoField(primary_key=True) PK가 없을 경우 자동 생성
    title = models.CharField(verbose_name="제목", max_length=100) # 최대 길이 반드시 지정 VARCHAR 타입
    content = models.TextField(verbose_name="내용") # 최대 길이 제한이 없음 CLOB(제한2GB), TEXT 타입
    create_at = models.DateField(auto_now_add=True) # 타임존 기준으로 잡힘
    update_at = models.DateTimeField(auto_now=True) # 수정될 때 마다 자동적으로 잡힘
    region = models.CharField(verbose_name="지역",
                              max_length=20,
                              choices=REGION_CHOICE,
                              default='Asia')
    lnglat = models.CharField(verbose_name="경도,위도",
                              max_length=100,
                              blank=True,
                              null=True,
                              help_text="경도, 위도 포맷",
                              validators=[lnglat_valudator]) # 38.5,125,4125
    url = models.URLField(blank=True,
                          null=True
                          )

    def __str__(self):
        return "제목 : {} - {}작성, {:%Y-%m-%d %p %I:%M:%S} 최종수정".format(self.title,
                                                                 self.create_at,
                                                                 self.update_at)
    class Meta: # 반드시Mate
        ordering = ['-update_at'] # orderby 대신 사용