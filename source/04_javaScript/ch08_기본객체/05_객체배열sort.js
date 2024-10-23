function Student(name, kor, mat){//생성자 함수
    this.name = name;
    this.kor = kor;
    this.mat = mat;
}
Student.prototype.getsum = function(){
    return this.kor + this.mat;
}
Student.prototype.toString = function(){
    return this.name + " (" + this.kor + "," + this.mat + "," + this.getsum() + ") ";
}
var Student = [new Student("홍", 70, 90),
    new Student("박", 99, 98),
    new Student("이", 57, 71),
    new Student("윤", 82, 83),
];
var Studentscopy = [...Student]; //깊은복사
Studentscopy.sort(function(left, right){
    return right.getsum() - left.getsum(); // 총점기준으로 내림차순정렬
});
console.log("원본");
Student.forEach((data, idx)=>{
    console.log(idx + "," + data.toString());
});
console.log("정렬된복사본");
Studentscopy.forEach((data, idx)=>{
    console.log(idx +"," + data.toString());
});