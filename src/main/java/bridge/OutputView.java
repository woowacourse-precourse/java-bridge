package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private List<String> upBridgeMap = new ArrayList<>();
	private List<String> downBridgeMap = new ArrayList<>();

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(boolean isCross, String userMove) {
		storeMap(isCross, userMove);
		String replaceUpBridgeMap = String.join(Constant.BOARD, upBridgeMap);
		String replaceDownBridgeMap = String.join(Constant.BOARD, downBridgeMap);
		System.out.println(Constant.FIRST_BRACE + replaceUpBridgeMap + Constant.END_BRACE);
		System.out.println(Constant.FIRST_BRACE + replaceDownBridgeMap + Constant.END_BRACE + Constant.LINE_BLANK);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult() {
	}

	public void storeMap(boolean isCross, String userMove) {
		if (isCross)
			trueStoreMap(userMove);
		if (!isCross)
			falseStoreMap(userMove);
	}

	public void trueStoreMap(String userMove) {
		if (userMove.equals(Constant.SPELLING_U)) {
			upBridgeMap.add(Constant.CIRCLE);
			downBridgeMap.add(Constant.BLANK);
		}
		if (userMove.equals(Constant.SPELLING_D)) {
			upBridgeMap.add(Constant.BLANK);
			downBridgeMap.add(Constant.CIRCLE);
		}
	}

	public void falseStoreMap(String userMove) {
		if (userMove.equals(Constant.SPELLING_U)) {
			upBridgeMap.add(Constant.CROSS);
			downBridgeMap.add(Constant.BLANK);
		}
		if (userMove.equals(Constant.SPELLING_D)) {
			upBridgeMap.add(Constant.BLANK);
			downBridgeMap.add(Constant.CROSS);
		}
	}

	public void resetBridgeMap() {
		upBridgeMap.clear();
		downBridgeMap.clear();
	}
}