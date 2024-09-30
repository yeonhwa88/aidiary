package strategy1.step5.modularization1;

import strategy1.step4.interfaces1.*;

public class SuperRobot extends Robot {

	@Override
	public void shape() {
		System.out.println("슈퍼 로봇은 팔, 다리, 머리, 몸통으로 이루어져 있습니다.");
	
	}
	public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new KnifeLazer());
	}

}
