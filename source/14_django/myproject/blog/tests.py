from django.test import TestCase
import re
# 38.5,125.4125     38,128
value = input('경도, 위도 :')
if not re.match(r'(\d+\.?\d*),(\d+\.?\d*)',value):# * 0번이상 있을수도 없을수도있기때문
    print('경도, 위도 포맷으로 입력 안하셨습니다.')