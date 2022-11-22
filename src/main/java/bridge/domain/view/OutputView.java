package bridge.domain.view;

import bridge.domain.Map;

import java.util.List;

import static bridge.Constants.*;

public class OutputView {

	public static void printMap(Map map) {
		for (List<String> bridge : map.getMap()) {
			System.out.println(printLine(bridge));
		}
		System.out.println();
	}

	public static String printLine(List<String> bridge) {
		String result = START;

		for (String status : bridge) {
			result += status;
			result += MIDDLE;
		}
		result = result.substring(0, result.length() - 3);
		result += END;
		return result;
	}

	public static void printResult(Map map, String result, int count) {
		System.out.println(MESSAGE_RESULT_TITLE);
		printMap(map);
		System.out.println(MESSAGE_RESULT + result);
		System.out.println(MESSAGE_TRY + count);
	}
}
