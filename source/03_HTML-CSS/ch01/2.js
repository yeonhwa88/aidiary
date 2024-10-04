//2. js
// 다른이름으로 저장 (utf-8인코딩 방법으로 저장)
/* 동적인 부분(JacaScript) */
name = prompt("이름은 ?", "홍길동"); // 취소를 클릭하면 'null' 리턴 // prompt (1:질문,2:디폴트값) 디폴트값은 안해도 가능
if (name != "null" && name != "") {
    document.write(name + "님 반갑습니다 <br>")
}