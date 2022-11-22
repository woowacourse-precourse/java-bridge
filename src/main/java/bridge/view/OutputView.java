package bridge.view;

import bridge.domain.Command;
import bridge.domain.Result;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME_MSG = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_MSG = "최종 게임 결과";
    private static final String IS_GAME_SUCCEED = "게임 성공 여부: ";
    private static final String TOTAL_ATTEMPTS = "총 시도한 횟수: ";
    private static final String START_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String MIDDLE_BRIDGE = " | ";
    private static final String SUCCESS_PATH = "O";
    private static final String FAILURE_PATH = "X";
    private static final String NOTHING_PATH = " ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Command> bridgeCommand, Result result) {
        System.out.print(getLineOfMap(Command.UP, bridgeCommand));
        System.out.println(getLastLineOfMap(Command.UP, bridgeCommand.get(bridgeCommand.size() - 1), result));
        System.out.print(getLineOfMap(Command.DOWN, bridgeCommand));
        System.out.println(getLastLineOfMap(Command.DOWN, bridgeCommand.get(bridgeCommand.size() - 1), result) + "\n");
    }


    private String getLineOfMap(Command direction, List<Command> bridgeRecord) {
        StringBuilder squaresOfLine = new StringBuilder();
        for (int i = 0; i < bridgeRecord.size() - 1; i++) {
            squaresOfLine.append(getResultOfPath(direction, bridgeRecord.get(i), Result.SUCCESS));
            squaresOfLine.append(MIDDLE_BRIDGE);
        }
        return START_BRIDGE + squaresOfLine;
    }


    private String getLastLineOfMap(Command direction, Command lastCommand, Result result) {
        return getResultOfPath(direction, lastCommand, result) + END_BRIDGE;
    }

    private String getResultOfPath(Command direction, Command command, Result result) {
        if (command.equals(direction)) {
            if (!result.equals(Result.FAIL)){
                return SUCCESS_PATH;
            }
            return FAILURE_PATH;
        }
        return NOTHING_PATH;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Command> bridgeRecord, int attempts, Result result) {
        System.out.println(FINAL_GAME_MSG);
        printMap(bridgeRecord, result);

        System.out.println(IS_GAME_SUCCEED + result.getString());
        System.out.println(TOTAL_ATTEMPTS + attempts);
    }

    public void printStart() {
        System.out.println(START_GAME_MSG);
    }
}
