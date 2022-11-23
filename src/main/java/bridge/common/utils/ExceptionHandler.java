package bridge.common.utils;

import bridge.view.OutputView;

public class ExceptionHandler {

	public static <T> T getCorrectInput(Callback<T> callback) {
		while (true) {
			try {
				return callback.run();
			} catch (IllegalArgumentException e) {
				OutputView.printExceptionMessage(e.getMessage());
			}
		}
	}
}
