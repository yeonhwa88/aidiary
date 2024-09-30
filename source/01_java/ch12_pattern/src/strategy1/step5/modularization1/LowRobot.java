package strategy1.step5.modularization1;

import strategy1.step4.interfaces1.FlyNo;
import strategy1.step4.interfaces1.KnifeNo;
import strategy1.step4.interfaces1.MissileNo;

public class LowRobot extends Robot{

	@Override
	public void shape() {
		System.out.println("로우 로봇은 팔, 다리, 머리, 몸통으로 이루어져 있습니다.");
		
	}
	public LowRobot() {
		setFly(new FlyNo());
		setMissile(new MissileNo());
		setKnife(new KnifeNo());
		
	}

}
