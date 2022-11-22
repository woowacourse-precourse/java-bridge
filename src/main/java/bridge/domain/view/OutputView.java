package bridge.domain.view;

import bridge.domain.Map;

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

	static public void printMap(Map map) {
		for (List<String> bridge : map.getMap()){
			System.out.println(printLine(bridge));
		}
		System.out.println();
	}

	static public String printLine(List<String> bridge) {
		String result = START;

		for (String status : bridge){
			result += status;
			result += MIDDLE;
		}
		result = result.substring(0, result.length() -3);
		result += END;
		return result;
	}

	static public void printResult(Map map, String result, int count) {
		System.out.println(MESSAGE_RESULT_TITLE);
		printMap(map);
		System.out.println(MESSAGE_RESULT + result);
		System.out.println(MESSAGE_TRY + count);
	}
}
