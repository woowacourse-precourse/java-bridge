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
	public String printMap(List<String> bridges, List<String> moves) {
		StringBuilder log = new StringBuilder();
		BridgeMoveCommand[] values = BridgeMoveCommand.values();
		for(BridgeMoveCommand bridgeMoveCommand : values){
			log.append(BRIDGE_RESULT_OPEN);
			appendMap(log,moves,bridges,bridgeMoveCommand.getCommand());
			log.append(BRIDGE_RESULT_CLOSE).append(ENTER);
		}
		System.out.print(log);
		return log.toString();
	}

	public void appendMap(StringBuilder log ,List<String> moves,List<String> bridges,String command){
		for (int i = 0; i < moves.size() ; i++) {
			if (i > 0){
				log.append(BRIDGE_RESULT_MIDDLE);
			}
			if(!command.equals(moves.get(i))){
				log.append(BLANK);
				continue;
			}
			log.append(isEquals(bridges,moves,i));
		}
	}
	public String isEquals(List<String> bridges,List<String> moves,int index){
		String a = bridges.get(index);
		String b = moves.get(index);
		if(a.equals(b)){
			return SUCCESS;
		}
		return FAIL;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeResult bridgeResult) {
		System.out.println("최종 게임 결과");
		System.out.println(bridgeResult.getMap() + ENTER);
		System.out.println("게임 성공 여부: " + bridgeResult.isSuccess());
		System.out.println("총 시도한 횟수: " + bridgeResult.getCountOfAttemps());
	}
}
