# sample_pac/cd/c.py - ab/a.py을 참조
from ..ab import a
# ..은 상위폴더
# .은 현재폴더
def nice():
    print('sample_pac/cd안의 c모듈안의 nice') # a까지 같이 호출
    a.hello()