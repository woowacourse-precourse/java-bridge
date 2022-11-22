package bridge;

import static bridge.view.Validator.*;

import bridge.controller.ControllerV2;

public class Application {

	public static void main(String[] args) {
		ControllerV2 controllerV2 = new ControllerV2();
		try {
			controllerV2.init();
			controllerV2.run();
			controllerV2.end();
		} catch (IllegalArgumentException e) {
			System.out.println(INVALID_INPUT);
		}
	}
}
