package strategy1.step5.modularization1;

import strategy1.step4.interfaces1.*;


public class StandardRobot extends Robot{

	@Override
	public void shape() {
		System.out.println("스텐다드 로봇은 팔, 다리, 머리, 몸통으로 이루어져 있습니다.");
		
	}
	public StandardRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());
		setKnife(new Knifewood());
		
	}

}
