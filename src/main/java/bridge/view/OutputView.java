package bridge.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";

    private static final int BRIDGE_FIRST_TRY_INDEX = 0;
    private static final int BRIDGE_ONE_TRY_SPACE_SIZE = 4;
    private static final String BRIDGE_FAIL_SPACE_BLANK = "   ";
    private static final String CLOSING_BRACKET = "]";

    private static final StringBuilder upsideBridge = new StringBuilder("[]");
    private static final StringBuilder downsideBridge = new StringBuilder("[]");
    private static final StringBuilder SUCCESSFUL_MARK = new StringBuilder(" O ");
    private static final StringBuilder FAILURE_MARK = new StringBuilder(" X ");



    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public static void printInputBridgeSizeMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap() {
        System.out.println(upsideBridge);
        System.out.println(downsideBridge);
    }

    public static void printMovingSelectMessage() {
        System.out.println(MOVING_SELECT_MESSAGE);
    }

    public static void printRetryMessage() {
        System.out.println(GAME_RETRY_MESSAGE);
    }

    public static void printResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printSuccessOrFailureResult(int retryCount, boolean result) {
        if (result){
            System.out.println("게임 성공 여부: " + "성공");
            System.out.println("총 시도한 횟수: " + retryCount);
        }
        if (!result) {
            System.out.println("게임 성공 여부: " + "실패");
            System.out.println("총 시도한 횟수: " + retryCount);
        }
    }

    public static void replaceCloseBracket(int bracketIndex) {
        if (bracketIndex > BRIDGE_FIRST_TRY_INDEX) {
            upsideBridge.replace(BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, "|");
            downsideBridge.replace(BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, BRIDGE_ONE_TRY_SPACE_SIZE * bracketIndex, "|");
        }
    }

    private static void moveUpside(int index) {
        upsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1,SUCCESSFUL_MARK);
        downsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1, BRIDGE_FAIL_SPACE_BLANK);
    }

    private static void moveDownside(int index) {
        upsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1, BRIDGE_FAIL_SPACE_BLANK);
        downsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + 1,SUCCESSFUL_MARK);
    }

    private static void moveFailUpside(int index) {
        upsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1,FAILURE_MARK);
        downsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1, BRIDGE_FAIL_SPACE_BLANK);
    }

    private static void moveFailDownside(int index) {
        upsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1, BRIDGE_FAIL_SPACE_BLANK);
        downsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE *index+1,FAILURE_MARK);
    }

    private static void deleteBridgeOverSecondTry(int index) {
        upsideBridge.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
        downsideBridge.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
    }

    private static void deleteBridgeFirstTry() {
        upsideBridge.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
        downsideBridge.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
    }

    private static void appendClosingBracket() {
        upsideBridge.append(CLOSING_BRACKET);
        downsideBridge.append(CLOSING_BRACKET);
    }

    public static void goBackBeforeOneStep(int index) {
        if (index > BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeOverSecondTry(index);
            appendClosingBracket();
        }
        if (index == BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeFirstTry();
        }
    }

    public static void moveSuccess(String moveSide, int index) {
        if (moveSide.equals("U")) {
            moveUpside(index);
        }
        if (moveSide.equals("D")) {
            moveDownside(index);
        }
        printMap();
        }

    public static void moveFail(String moveSide, int index) {
        if (moveSide.equals("U")) {
            moveFailUpside(index);
        }
        if (moveSide.equals("D")) {
            moveFailDownside(index);
        }
        printMap();
    }

    public static void printBridgeResult(boolean result, int tryCount) {
        OutputView.printResultMessage();
        OutputView.printMap();
        OutputView.printSuccessOrFailureResult(tryCount, result);
    }
}
