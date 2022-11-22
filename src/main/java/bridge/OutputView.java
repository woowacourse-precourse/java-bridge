package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<String> bridgeU, List<String> bridgeD) {
		String bridgeUp = String.join("|", bridgeU);
		String bridgeDown = String.join("|", bridgeD);
		System.out.println("[" + bridgeUp + "]");
		System.out.println("[" + bridgeDown + "]");
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(List<String> bridgeU, List<String> bridgeD) {
		System.out.println(Constants.TOTAL_RESULT);
		printMap(bridgeU, bridgeD);
	}

	public void win(int count) {
		System.out.println(Constants.GAME_SUCCESS);
		System.out.println(Constants.TOTAL_COUNT + count);
	}

	public void Fail(int count) {
		System.out.println(Constants.GAME_FAIL);
		System.out.println(Constants.TOTAL_COUNT + count);
	}

}

