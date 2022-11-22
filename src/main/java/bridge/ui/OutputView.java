package bridge.ui;


import bridge.User;
import java.util.List;
import bridge.BridgeSymbol;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<String> userBridge, List<String> userSelect) {
		printUpMap(userBridge, userSelect);
		printDownMap(userBridge, userSelect);
	}

	private void printUpMap(List<String> userBridge, List<String> userSelect) {
		System.out.print(OutputMessage.LEFT.getMsg());
		for (int i = 0; i < userSelect.size(); i++) {
			if (Objects.equals(userSelect.get(i), BridgeSymbol.UP.getSymbol())) {
				System.out.print(userBridge.get(i));
			}
			if (Objects.equals(userSelect.get(i), BridgeSymbol.DOWN.getSymbol())) {
				System.out.print(OutputMessage.BLANK.getMsg());
			}
			if (i != userBridge.size() - 1) {
				System.out.print(OutputMessage.MIDDLE.getMsg());
			}
		}
		System.out.println(OutputMessage.RIGHT.getMsg());
	}

	private void printDownMap(List<String> userBridge, List<String> userSelect) {
		System.out.print(OutputMessage.LEFT.getMsg());
		for (int i = 0; i < userBridge.size(); i++) {
			if (Objects.equals(userSelect.get(i), BridgeSymbol.DOWN.getSymbol())) {
				System.out.print(userBridge.get(i));
			}
			if (Objects.equals(userSelect.get(i), BridgeSymbol.UP.getSymbol())) {
				System.out.print(OutputMessage.BLANK.getMsg());
			}
			if (i != userBridge.size() - 1) {
				System.out.print(OutputMessage.MIDDLE.getMsg());
			}
		}
		System.out.println(OutputMessage.RIGHT.getMsg());
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(User user) {
		System.out.println(OutputMessage.RESULT_GAME.getMsg());
		printMap(user.bridge, user.select);
		System.out.println(OutputMessage.IS_SUCCESS.getMsg() + user.isSuccess);
		System.out.println(OutputMessage.STATS_GAME.getMsg() + user.tryCount);
	}

	public void printInit() {
		System.out.println(OutputMessage.START_GAME.getMsg());
		System.out.println();
		System.out.println(OutputMessage.INPUT_BRIDGE.getMsg());
	}

	public void printMoveMsg() {
		System.out.println(OutputMessage.SELECT_MOVING.getMsg());
	}

	public void printReTry() {
		System.out.println(OutputMessage.RESTART_GAME.getMsg());
	}
}
