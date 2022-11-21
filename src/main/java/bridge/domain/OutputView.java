package bridge.domain;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private StringBuilder result;
	private String currentStateBridge = "";

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public String printMap(List<List<String>> upDownBridgeList) {
		result = new StringBuilder();
		for (List<String> bridge : upDownBridgeList) {
			result.append("[");
			for (int i = 0; i < bridge.size(); i++) {
				result.append(" " + bridge.get(i) + " |");
			}
			result.replace(result.length() - 1, result.length(), "]\n");
		}
		this.currentStateBridge = result.toString();
		return result.toString();
	}

	public String getAndPrintCurrentStateBridge(List<List<String>> upDownBridgeList) {
		printMap(upDownBridgeList);
		printCurrentStateBridge(upDownBridgeList);
		return this.currentStateBridge;
	}

	public String getCurrentStateBridge(List<List<String>> upDownBridgeList) {
		printMap(upDownBridgeList);
		return this.currentStateBridge;
	}

	public void printCurrentStateBridge(List<List<String>> upDownBridgeList) {
		printMap(upDownBridgeList);
		System.out.println(this.currentStateBridge);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(int tryCount, String currentStateBridge, String successOrFailure) {
		System.out.println("최종 게임 결과");
		System.out.println(currentStateBridge);
		System.out.printf("게임 성공 여부: %s\n", successOrFailure);
		System.out.printf("총 시도한 횟수: %d", tryCount);
	}
}
