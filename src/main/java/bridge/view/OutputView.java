package bridge.view;

/*
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String STARTING_MSG = "다리 건너기 게임을 시작합니다.";
    private final String PRINT_RESULT_MSG = "최종 게임 결과";
    private final String GAME_SUCCESS_OR_NOT_MSG = "게임 성공 여부: ";
    private final String TOTAL_NUMBER_MSG = "총 시도한 횟수: ";
    private final String START_OF_BRIDGE = "[";
    private final String END_OF_BRIDGE = "]";
    private final String CROSSE_BRIDGE = " O ";
    private final String SPACE = "   ";
    private final String SEPARATION = "|";
    private final String FAIL_TO_CROSSE_BRIDGE = " X ";
    private final String UP = "U";
    private final String DOWN = "D";
    private final String WRONG_WHEN_INPUT_UP = "UX";
    private final String WRONG_WHEN_INPUT_DOWN = "DX";
    private final int CALCULATING_SIZE_FOR_SEPARATION = 1;

    public void printStartingPhrase() {
        System.out.println(STARTING_MSG);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> userMoving) {
        printUpperBridge(userMoving);
        printLowerBridge(userMoving);
        //실행 예시와 맞추기 위해 한 칸 띄워준다.
        System.out.println();
    }

    private void printUpperBridge(List<String> userMoving) {
        System.out.print(START_OF_BRIDGE);
        for (int userMovingIndex = 0; userMovingIndex < userMoving.size(); userMovingIndex++) {
            if (userMoving.get(userMovingIndex).equals(UP)) System.out.print(CROSSE_BRIDGE);
            if (userMoving.get(userMovingIndex).equals(WRONG_WHEN_INPUT_UP)) System.out.print(FAIL_TO_CROSSE_BRIDGE);
            if (userMoving.get(userMovingIndex).equals(DOWN) || userMoving.get(userMovingIndex).equals(WRONG_WHEN_INPUT_DOWN)) System.out.print(SPACE);
            if (userMovingIndex < userMoving.size() - CALCULATING_SIZE_FOR_SEPARATION) System.out.print(SEPARATION);
        }
        System.out.println(END_OF_BRIDGE);
    }

    private void printLowerBridge(List<String> userMoving) {
        System.out.print(START_OF_BRIDGE);
        for (int userMovingIndex = 0; userMovingIndex < userMoving.size(); userMovingIndex++) {
            if (userMoving.get(userMovingIndex).equals(DOWN)) System.out.print(CROSSE_BRIDGE);
            if (userMoving.get(userMovingIndex).equals(WRONG_WHEN_INPUT_DOWN)) System.out.print(FAIL_TO_CROSSE_BRIDGE);
            if (userMoving.get(userMovingIndex).equals(UP) || userMoving.get(userMovingIndex).equals(WRONG_WHEN_INPUT_UP)) System.out.print(SPACE);
            if (userMovingIndex < userMoving.size() - CALCULATING_SIZE_FOR_SEPARATION) System.out.print(SEPARATION);
        }
        System.out.println(END_OF_BRIDGE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, String successOrFail, int count) {
        System.out.println(PRINT_RESULT_MSG);
        printUpperBridge(bridge);
        printLowerBridge(bridge);
        //실행 예시와 맞추기 위해 한 칸 띄워준다.
        System.out.println();
        System.out.println(GAME_SUCCESS_OR_NOT_MSG + successOrFail);
        System.out.println(TOTAL_NUMBER_MSG + count);
    }
}
