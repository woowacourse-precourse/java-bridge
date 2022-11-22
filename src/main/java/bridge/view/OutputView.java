package bridge.view;

import bridge.domain.Result;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_TO_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String FINAL_GAME_RESULT_GUIDE_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TOTAL_NUMBER_OF_TRIAL_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAILED = "실패";
    private static final String START_POINT = "[ ";
    private static final String END_POINT = " ]";
    private static final String DELIMITER = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        List<String> up = result.getUp();
        List<String> down = result.getDown();

        printUpAndDown(up);
        printUpAndDown(down);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result) {
        printFinalGameResultGuideMessage();
        printMap(result);
        printResultMessage(result.getIsSuccess(), result.getNumberOfTrial());
    }

    private void printUpAndDown(List<String> bridge) {
        System.out.print(START_POINT);
        for (int i = 0; i < bridge.size(); i++) {
            System.out.print(bridge.get(i));
            if (i == bridge.size() - 1) {
                System.out.print(END_POINT);
                break;
            }
            System.out.print(DELIMITER);
        }
        System.out.println();
    }

    public void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void printInputBridgeSizeMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    public void printInputMoveToMessage() {
        System.out.println(INPUT_MOVE_TO_MESSAGE);
    }

    public void printInputRetryMessage() {
        System.out.println(INPUT_RETRY_MESSAGE);
    }

    public void printFinalGameResultGuideMessage() {
        System.out.println(FINAL_GAME_RESULT_GUIDE_MESSAGE);
    }

    public void printResultMessage(boolean isSuccess, int numberOfTrial) {
        System.out.print(GAME_RESULT_MESSAGE);
        if (isSuccess) {
            System.out.println(SUCCESS);
        }
        if (!isSuccess) {
            System.out.println(FAILED);
        }
        System.out.print(TOTAL_NUMBER_OF_TRIAL_MESSAGE);
        System.out.println(numberOfTrial);
    }
}
