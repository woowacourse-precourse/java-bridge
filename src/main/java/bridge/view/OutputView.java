package bridge.view;

import static bridge.controller.Constant.*;

import java.util.ArrayList;
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
	public static void printMap(String upsideBridge) {
		List<String> upsideCase = new ArrayList<>(List.of(upsideBridge.split("")));
		int i = 0;
		while (i < 3) {
			upsideCase.remove(0);
			i++;
		}
		System.out.println(OPEN_BRACKET + toString(upsideCase) + CLOSE_BRACKET);
	}

	public String toString(List<String> list) {
		String line = "";
		for (int i = 0; i < list.size(); i++){
			line += list.get(i);
		}
		return line;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult() {
		System.out.println(RESULT);
	}
}
