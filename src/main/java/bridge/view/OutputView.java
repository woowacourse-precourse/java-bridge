package bridge.view;

import bridge.data.Moving;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String BRIDGE_LENGTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String FAIL = "실패";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String GAME_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    private static final String MOVING_CHOICE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String SUCCESS = "성공";
    private static final String TOTAL_TRY = "총 시도한 횟수: ";

    /**
     * 게임 시작 시 필요한 메세지를 출력한다.
     */
    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(BRIDGE_LENGTH_INPUT_MESSAGE);
    }

    /**
     * 이동할 칸을 입력하라는 메세지를 출력한다.
     */
    public void printMoveInputMessage() {
        System.out.println(MOVING_CHOICE_MESSAGE);
    }

    /**
     * 게임 재진행 여부를 확인하는 메세지를 출력한다.
     */
    public void printRetryMessage() {
        System.out.println(RETRY_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> map) {
        List<String> upLine = map.get(Moving.UP.ordinal());
        List<String> downLine = map.get(Moving.DOWN.ordinal());
        printOneLineMap(upLine);
        printOneLineMap(downLine);
        nextLine();
    }

    private void printOneLineMap(List<String> line) {
        System.out.print("[");
        for (int i = 0; i < line.size(); i++) {
            System.out.print(line.get(i));
            if (i == line.size() - 1) {
                break;
            }
            System.out.print("|");
        }
        System.out.println("]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> map, boolean success, int tryCount) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(map);
        printSuccess(success);
        System.out.println(TOTAL_TRY + tryCount);
    }

    private void printSuccess(boolean success) {
        System.out.print(GAME_SUCCESS_OR_FAIL);
        if (success) {
            System.out.println(SUCCESS);
            return;
        }
        System.out.println(FAIL);
    }

    public void nextLine() {
        System.out.println();
    }
}
