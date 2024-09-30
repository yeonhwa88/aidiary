package strategy1.step5.modularization1;

import strategy1.step4.interfaces1.*;

public abstract class Robot {
	
	private FlyImpl fly;
	private KnifeImpl knife;
	private MissileImpl missile;
	public abstract void shape(); //추상메소드
	
	public void actWork() {
		System.out.println("걸을 수 있습니다.");
	}
	
	public void actRun() {
		System.out.println("뛸 수 있습니다.");
	}
	
	public void actFly() {
		fly.Fly();
	}
	
	public void actknife() {
		knife.Knife();
	}
	
	public void actmssile() {
		missile.Missile();
	}

	public void setFly(FlyImpl fly) {
		this.fly = fly;
	}

	public void setKnife(KnifeImpl knife) {
		this.knife = knife;
	}

	public void setMissile(MissileImpl missile) {
		this.missile = missile;
	}
}
