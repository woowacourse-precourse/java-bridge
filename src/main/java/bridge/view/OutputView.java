package bridge.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다";
    private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String MOVING_SELECT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GAME_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";

    private static final int BRIDGE_FIRST_TRY_INDEX = 0;
    private static final int BRIDGE_ONE_TRY_SPACE_SIZE = 4;
    private static final int ADDITIONAL_NUMBER_FOR_EXCLUDE_BRACKET = 1;
    private static final String BRIDGE_FAIL_SPACE_BLANK = "   ";
    private static final String CLOSING_BRACKET = "]";
    private static final StringBuilder SUCCESSFUL_MARK = new StringBuilder(" O ");
    private static final StringBuilder FAILURE_MARK = new StringBuilder(" X ");
    private static final StringBuilder upsideBridge = new StringBuilder("[]");
    private static final StringBuilder downsideBridge = new StringBuilder("[]");



    public static void printGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public static void printInputBridgeSizeMessage() {
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
    }

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

    // forExcludeBracketIndex
    /**
     * 위 칸 입력 후 다리 건너기 성공했을 시 Map에 O 표시를 추가하는 메소드
     * index에서 바로 insert 할 경우 닫는 괄호가 추가 되
     * @param index
     */
    private static void moveSuccessUpside(int index) {
        upsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + ADDITIONAL_NUMBER_FOR_EXCLUDE_BRACKET ,SUCCESSFUL_MARK);
        downsideBridge.insert(BRIDGE_ONE_TRY_SPACE_SIZE * index + ADDITIONAL_NUMBER_FOR_EXCLUDE_BRACKET , BRIDGE_FAIL_SPACE_BLANK);
    }

    private static void moveSuccessDownside(int index) {
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

    private static void deleteBridgeMapOverSecondTry(int index) {
        upsideBridge.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
        downsideBridge.delete(BRIDGE_ONE_TRY_SPACE_SIZE * index , 2 * BRIDGE_ONE_TRY_SPACE_SIZE * index + 1);
    }

    private static void deleteBridgeMapFirstTry() {
        upsideBridge.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
        downsideBridge.delete(1, BRIDGE_ONE_TRY_SPACE_SIZE);
    }

    private static void appendClosingBracket() {
        upsideBridge.append(CLOSING_BRACKET);
        downsideBridge.append(CLOSING_BRACKET);
    }

    public static void goBackBeforeOneStep(int index) {
        if (index > BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeMapOverSecondTry(index);
            appendClosingBracket();
        }
        if (index == BRIDGE_FIRST_TRY_INDEX) {
            deleteBridgeMapFirstTry();
        }
    }

    public static void moveSuccess(String moveSide, int index) {
        if (moveSide.equals("U")) {
            moveSuccessUpside(index);
        }
        if (moveSide.equals("D")) {
            moveSuccessDownside(index);
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
