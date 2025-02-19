from django.db import models

class Post(models.Model): # 테이블명 :blog_post
    # id = models.AutoField(primary_key=True) PK가 없을 경우 자동 생성
    title = models.CharField(max_length=100) # 최대 길이 반드시 지정 VARCHAR 타입
    content = models.TextField() # 최대 길이 제한이 없음 CLOB(제한2GB), TEXT 타입
    create_at = models.DateField(auto_now_add=True) # 타임존 기준으로 잡힘
    update_at = models.DateTimeField(auto_now=True) # 수정될 때 마다 자동적으로 잡힘
    def __str__(self):
        return "제목 : {} - {}작성, {:%Y-%m-%d %p %I:%M:%S} 최종수정".format(self.title,
                                                                 self.create_at,
                                                                 self.update_at)
    class Meta: # 반드시Mate
        ordering = ['-update_at'] # orderby 대신 사용