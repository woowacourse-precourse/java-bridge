package bridge.view;

import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.result.BridgeResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public static final String ENTER = System.lineSeparator();
	private static final String PRINT_GAME_START = "다리 건너기 게임을 시작합니다.";
	private static final String PRINT_SIZE_SELECT = ENTER + "다리의 길이를 입력해주세요.";


	private static final String MOVE_SELECT = ENTER + "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String GAME_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String SUCCESS = " O ";
	private static final String FAIL = " X ";
	private static final String BLANK = "   ";
	private static final String BRIDGE_RESULT_OPEN = "[";
	private static final String BRIDGE_RESULT_CLOSE = "]";
	private static final String BRIDGE_RESULT_MIDDLE = "|";

	public void printStartGame() {
		System.out.println(PRINT_GAME_START);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(BridgeResult bridgeResult) {
		System.out.println(getMaps(bridgeResult.getLists()));
	}
	public String getMaps(List<List<String>> lists){ //repository에서하는게 맞을까 아니면 여기서 하는게 맞을까? 출력관련은 outview에서 해야된다?
		StringBuilder log = new StringBuilder();
		int size = BridgeMoveCommand.getSize()-1;
		for (int i = size; i >= 0; i--) {
			log.append(BRIDGE_RESULT_OPEN);
			log.append(getBody(lists.get(i)));
			log.append(BRIDGE_RESULT_CLOSE).append(ENTER);
		}
		return log.toString();
	}
	public String getBody(List<String> list){
		return String.join(BRIDGE_RESULT_MIDDLE, list);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeResult bridgeResult) {
		System.out.println("최종 게임 결과");
		printMap(bridgeResult);
		System.out.println("게임 성공 여부: " + bridgeResult.isSuccess());
		System.out.println("총 시도한 횟수: " + bridgeResult.getCountOfAttemps());
	}
}
