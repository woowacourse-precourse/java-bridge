package bridge.view;

import bridge.model.OutputMessage;
import bridge.model.UserKeySet;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String LINE_FORMAT = "[ %s ]\n";
    private static final String CELL_SEPARATOR = " | ";
    private static final String NOT_MOVED = " ";
    private static final String CORRECT_MOVED = "O";
    private static final String WRONG_MOVED = "X";
    public void printGameStartMsg() {
        System.out.println(OutputMessage.GAME_START_MSG);
        System.out.println();
    }

    public void printInputBridgeSizeMsg() {
        System.out.println(OutputMessage.INPUT_BRIDGE_SIZE_MSG);
    }

    public void printInputMoveCellMsg() {
        System.out.println(OutputMessage.INPUT_MOVE_CELL_MSG);
    }

    public void printRestartMsg() {
        System.out.println(OutputMessage.RESTART_MSG);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * @param bridge 다리 정보
     * @param movements 플레이어가 이동한 기록
     */
    public void printMap(List<String> bridge, List<String> movements) {
        for(String line : List.of(UserKeySet.UP.toString(), UserKeySet.DOWN.toString())) {
            printMapLine(bridge, movements, line);
        }
    }

    private void printMapLine(List<String> bridge, List<String> movements, String line) {
        String mapLine = getMapLine(bridge, movements, line);
        System.out.printf(LINE_FORMAT, mapLine);
    }

    private String getMapLine(List<String> bridge, List<String> movements, String line) {
        List<String> mapLine = new ArrayList<>();
        for(int i = 0; i < movements.size(); i++) {
            String answer = bridge.get(i);
            String movement = movements.get(i);

            mapLine.add(getMapCell(line,answer, movement));
        }
        return String.join(CELL_SEPARATOR, mapLine);
    }

    private String getMapCell(String line, String answer, String movement) {
        if(!movement.equals(line)) {
            return NOT_MOVED;
        }

        if(!answer.equals(movement)) {
            return WRONG_MOVED;
        }

        return CORRECT_MOVED;
    }

    public void printGameResultMsg() {
        System.out.println(OutputMessage.GAME_RESULT_MSG);
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int trialCount) {
        String success = "실패";
        if(isSuccess) {
            success = "성공";
        }

        System.out.printf(OutputMessage.GAME_TRY_RESULT_MSG.toString(), success, trialCount);
    }
}
