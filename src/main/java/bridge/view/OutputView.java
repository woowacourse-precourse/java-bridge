package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String LENGTH_COMMAND_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_COMMAND_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RESTART_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String EXIT_MESSAGE = "최종 게임 결과";
    public static final String RESULT_MESSAGE = "게임 성공 여부: ";
    public static final String TOTAL_TRY_MESSAGE = "총 시도한 횟수: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";

    public static final String LENGTH_ERROR_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVING_ERROR_MESSAGE = "[ERROR] 위는 U, 아래는 D를 입력해야 합니다.";
    public static final String RESTART_ERROR_MESSAGE = "[ERROR] 재시도는 R, 종료는 Q를 입력해야 합니다.";

    public static final String LEFT_WALL = "[ ";
    public static final String PARTITION = " | ";
    public static final String RIGHT_WALL = " ]";

    public void printStart() {
        System.out.println(START_MESSAGE);
    }

    public void printLengthCommand() {
        System.out.println(LENGTH_COMMAND_MESSAGE);
    }

    public void printMovingCommand() {
        System.out.println(MOVING_COMMAND_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String currentMap) {
        System.out.println(currentMap);
    }


    public void printReStart() {
        System.out.println(RESTART_COMMAND_MESSAGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String currentMap, boolean isSuccess, int totalTryNumber) {
        System.out.println(EXIT_MESSAGE);
        printMap(currentMap);
        printSuccessOrFailMessage(isSuccess);
        System.out.println(TOTAL_TRY_MESSAGE + totalTryNumber);
    }

    public void printSuccessOrFailMessage(boolean isSuccess) {
        if(isSuccess) {
            System.out.println(RESULT_MESSAGE + SUCCESS);
            return;
        }
        System.out.println(RESULT_MESSAGE + FAIL);
    }
}
