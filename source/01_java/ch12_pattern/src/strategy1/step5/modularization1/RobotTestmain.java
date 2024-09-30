package strategy1.step5.modularization1;

import strategy1.step4.interfaces1.FlyHigh;
import strategy1.step4.interfaces1.KnifeToy;

public class RobotTestmain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		Robot[] robots = {superRobot, standardRobot, lowRobot};
		for (Robot robot : robots) {
			robot.shape();
			robot.actWork();
			superRobot.setFly(new FlyHigh());
			robot.actRun();
			robot.actFly();
			robot.actmssile();
			robot.actknife();
			lowRobot.setKnife(new KnifeToy());
		}
		System.out.println("슈퍼로봇의 나는 부품을 높이 나는 기능으로 업그레이드");
//		superRobot.actFly();
		System.out.println("로우로봇의 검을 장난감 검으로 업그레이드");
//		lowRobot.actknife();
}
}