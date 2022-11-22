package bridge.view;

public class View {
    private final static String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final static String REQUEST_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private final static String PICK_A_PART_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final static String ASK_RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final static String SUCCESS_RESULT_MESSAGE = "게임 성공 여부: 성공";
    private final static String FAILURE_RESULT_MESSAGE = "게임 성공 여부: 실패";
    private final static String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private final static String CHALLENGE_COUNT = "총 시도한 횟수: ";

    public static void gameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void requestBridgeLengthMessage() {
        System.out.println("\n" + REQUEST_BRIDGE_LENGTH_MESSAGE);
    }

    public static void requestPickAPartOfBridgeMessage() {
        System.out.println("\n" + PICK_A_PART_MESSAGE);
    }

    public static void askRetryMessage() {
        System.out.println("\n" + ASK_RETRY_MESSAGE);
    }

    public static void showFinalResult() {
        System.out.println("\n" + FINAL_RESULT_MESSAGE);
    }

    public static void failResult(int challenge) {
        System.out.println("\n" + FAILURE_RESULT_MESSAGE);
        System.out.println(CHALLENGE_COUNT + challenge);
    }

    public static void successResult(int challenge) {
        System.out.println("\n" + SUCCESS_RESULT_MESSAGE);
        System.out.println(CHALLENGE_COUNT + challenge);
    }

    public static void exceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }
}
