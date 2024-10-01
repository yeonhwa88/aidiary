package singleton1;

public class Single1 {
	private int i;
	private Single1() {}
	private static Single1 INSTANCE1 = new Single1(); //자주쓰는 싱글톤패턴
	public static Single1 getInstance() {
		return INSTANCE1;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
}
