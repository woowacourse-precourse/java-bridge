package bridge;

import java.util.List;

import static bridge.Constants.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 * 패키지 변경 ㅇ
 * 메서드 이름 변경 X
 * 인자, 리턴 타입 추가 변경 ㅇ
 * 메서드 추가 ㅇ
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(Map map) {
		for (List<String> bridge : map.getMap()){
			System.out.println(printLine(bridge));
		}
	}

	public String printLine(List<String> bridge) {
		String result = START;

		for (String status : bridge){
			result += status;
			result += MIDDLE;
		}
		result = result.substring(0, result.length() -3);
		result += END;
		return result;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult() {
	}
}
