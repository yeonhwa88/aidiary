package exex;
//클레스 : 속성(인스턴스변수 private), 생성자함수(속성데이터초기화), 메소드 (mathod), setter&getter , default
//Rect r1 = new Rect(); r1.setWidth(2); r2.setHeight(4);
//Rect r1 = new Rect(3);
//Rect r1 = new Rect(2, 4);
public class Rect {
	private int width;
	private int height;
	//생성자 함수
	public Rect() {}
	public Rect(int side) {
		width = side;
		height = side;
	}
	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}
	public int area() {
		return width*height;
	}
	public int getHeight(){
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
