let funvar = function(){
console.log("매개변수 없는 일반 함수 호출");
console.log("TEST");
}
funvar = () => {
    console.log("1. 매개변수 없는 구현이 2줄 이상인 화살표 일반 함수 호출");
    console.log("TEST");
}
funvar();
funvar = () => console.log("2. 매개변수 없는 구현이 1줄인 화살표 일반 함수 호출"); // 중괄호 생략 가능 
funvar();
funVar = i => {
    console.log('3. 매개변수 1개이고, 구현이 2줄이상 화살표 함수 호출 값 :' + i);
    console.log('TEST');
}
funvar(10);
funvar = i => console.log('4. 매개변수 1개이고, 구현이 1줄인 화살표 함수 호출 : ' + i);
funvar(20); 
funver = (i, j) => {
    console.log("5. 매개변수 2개 이상 함수 호출")
}
funver(10, 20);
funver = function(i, j){
    return i*10 + j;
}
funver = (i, j) => i*10 + j; // 위 함수표현식과 동일
console.log("6. 매개변수 2개, return이 있는 화살표 함수 호출 : " + funver(1, 2));
funver = x => x*x;
console.log("7. 매개변수 1개, return이 있는 함수 호출 : " + funver(2));