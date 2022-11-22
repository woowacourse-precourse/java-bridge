package bridge;

import bridge.controller.Controller;
import bridge.view.output.OutputView;

public class Application {

	private static final String EXIT_MESSAGE = "어플리케이션을 종료합니다.";

	public static void main(String[] args) {
		try {
			Controller controller = new Controller();
			controller.run();
		} catch (IllegalArgumentException ignored) {
		} finally {
			OutputView.withContentOf(EXIT_MESSAGE, true, false).ConsoleMessage();
		}
	}
}


