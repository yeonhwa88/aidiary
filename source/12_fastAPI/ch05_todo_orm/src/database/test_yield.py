def test_yield(): # yield : return과 비슷함
        try:
            yield  '세션 객체'
        finally:
            print('세션 객체 닫기')

ret = test_yield()
while True:
    value = next(ret, None)
    if value is None:
        break
    print(value)
