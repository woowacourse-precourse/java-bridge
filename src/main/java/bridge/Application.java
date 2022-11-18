package bridge;

import static bridge.view.Validator.*;

import bridge.controller.Controller;

public class Application {

	public static void main(String[] args) {
		Controller controller = new Controller();
		try {
			controller.init();
			controller.play(controller.getGame());
		} catch (IllegalArgumentException e) {
			System.out.println(INVALID_INPUT);
		}
	}
}