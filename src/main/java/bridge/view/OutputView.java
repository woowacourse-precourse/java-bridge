package bridge.view;

import static bridge.domain.Move.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
	private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요";
	private static final String SELECT_MOVING_POSITION_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String MAP_MESSAGE = "%s\n%s\n\n";
	private static final String INPUT_RETRY_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
	private static final String FINAL_RESULT = "게임 성공 여부: %s\n총 시도한 횟수: %d";
	private static final String PREFIX = "[ ";
	private static final String DELIMITER = " | ";
	private static final String SUFFIX = " ]";

	public static void printGameStart() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static void printBridgeLength() {
		System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
	}

	public static void printMoving() {
		System.out.println(SELECT_MOVING_POSITION_MESSAGE);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static void printMap(List<List<String>> map) {
		String up = map.stream().map(strings -> strings.get(UP.getMoveNumber()))
			.collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
		String down = map.stream().map(strings -> strings.get(DOWN.getMoveNumber()))
			.collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
		System.out.printf(MAP_MESSAGE, up, down);
	}

	public static void printRetryMessage() {
		System.out.println(INPUT_RETRY_COMMAND);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static void printResult(List<List<String>> map, String gameResult, int tryCount) {
		System.out.println(FINAL_RESULT_MESSAGE);
		printMap(map);
		System.out.printf(FINAL_RESULT, gameResult, tryCount);
	}
}
