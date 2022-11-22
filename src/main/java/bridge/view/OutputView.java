package bridge.view;

import bridge.game.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	@Override
	public String toString() {
		String result = BridgeGame.getTopMapResult().toString() + "\n";
		result += BridgeGame.getBottomMapResult().toString();

		result = result.replace("[", "[ ");
		result = result.replace("]", " ]");
		result = result.replace(", ", " | ");

		return result;
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap() {
		System.out.println(this);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(int tryCount) {
		GuideMessageView.GAME_RESULT_GUIDE_MESSAGE.printMessage();
		printMap();

		printSuccessOrFailGuideMessage();
		GuideMessageView.TRY_COUNT_GUIDE_MESSAGE.printMessage();
		printTryCount(tryCount);
	}

	private void printTryCount(int tryCount) {
		System.out.println(tryCount);
	}

	private void printSuccessOrFailGuideMessage() {
		printSuccessGuideMessage();
		printFailGuideMessage();
	}

	private static void printFailGuideMessage() {
		if (BridgeGame.isFailCrossBridge()) {
			GuideMessageView.GAME_FAIL_GUIDE_MESSAGE.printMessage();
		}
	}

	private static void printSuccessGuideMessage() {
		if (BridgeGame.isClearCrossBridge()) {
			GuideMessageView.GAME_SUCCESS_GUIDE_MESSAGE.printMessage();
		}
	}

	public static void printExceptionMessage(IllegalArgumentException exception) {
		System.out.println(exception.getMessage());
	}
}
