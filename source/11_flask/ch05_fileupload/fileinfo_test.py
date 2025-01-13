# 특정폴더 (upload/) 안의 파일들의 정보
import os
import datetime

def stamp2real(stamp):
    'stamp : (1970.1.1 ~ 특정시점까지의 초수)를 입력받아 특정시점을 가독성높은 문자'
    return datetime.datetime.fromtimestamp(stamp)

def info(filename):
    '파일 생성시간, 마지막 수정시간, 마지막 엑세스 시간, 파일 사이즈를 return'
    ctime = os.path.getctime(filename)
    mtime = os.path.getmtime(filename)
    atime = os.path.getatime(filename)
    size = os.path.getsize((filename))
    return ctime, mtime, atime, size

# print(stamp2real(1736734915.62))
filelist = os.listdir('./upload/')
# print(filelist)
for filename in filelist:
    ctime, mtime, atime, size = info('./upload/'+ filename)
    print('파일명 :',filename)
    print('파일생성시간 :', stamp2real(ctime))
    print('파일수정시간 :', stamp2real(mtime))
    print('파일접근시간 :', stamp2real(atime))
    if size<=100000: # size(byte단위) 1KB 보단 크고 1MB 이하
        print(f"{size/1024:.2f}KB")
    else:
        print(f"{size/(1024*1024):.2f}MB") # 1MB 이상