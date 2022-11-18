package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final String INPUT_BRIDGE_SIZE_MESSAGE = "\n다리의 길이를 입력해주세요.";
    private final String INPUT_MOVE_TO_MESSAGE = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String INPUT_RETRY_MESSAGE = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final String FINAL_GAME_RESULT_GUIDE_MESSAGE = "\n최종 게임 결과";
    private final String GAME_RESULT_MESSAGE= "\n게임 성공 여부: ";
    private final String TOTAL_NUMBER_OF_TRIAL_MESSAGE = "총 시도한 횟수: ";
    private final String SUCCESS = "성공";
    private final String FAILED = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
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

    public void printResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
        System.out.println(TOTAL_NUMBER_OF_TRIAL_MESSAGE);
    }
}
