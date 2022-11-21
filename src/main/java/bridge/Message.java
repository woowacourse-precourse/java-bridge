package bridge;

public enum Message {

    BRIDGE_OPTIONS("(위: U, 아래: D)"),
    GAME_OPTIONS("(재시도: R, 종료: Q)"),
    START_GAME_MESSAGE("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    INPUT_MOVE_BRIDGE_MESSAGE("이동할 칸을 선택해주세요."),
    INPUT_SELECT_GAME_RETRY("게임을 다시 시도할지 여부를 입력해주세요."),
    PRINT_RESULT("최종 게임 결과"),
    PRINT_GAME("게임 성공 여부: "),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: ");

    private String script;

    Message(String script) {
        this.script = script;
    }

    public static void startGameMessage() {
        System.out.println(START_GAME_MESSAGE.script);
    }

    public static void inputBridgeSizeMessage() {
        System.out.println();
        System.out.println(INPUT_BRIDGE_SIZE_MESSAGE.script);
    }

    public static void inputMoveBridgeMessage() {
        System.out.println(INPUT_MOVE_BRIDGE_MESSAGE.script + " " + BRIDGE_OPTIONS.script);
    }

    public static void inputSelectGameRetry() {
        System.out.println(INPUT_SELECT_GAME_RETRY.script + " " + GAME_OPTIONS.script);
    }

    public static void printResult(){
        System.out.println(PRINT_RESULT.script);
    }

    public static void printGame(){
        System.out.print(PRINT_GAME.script);
    }

    public static void gameSuccess(){
        System.out.println(GAME_SUCCESS.script);
    }

    public static void gameFail(){
        System.out.println(GAME_FAIL.script);
    }

    public static void tryCount(){
        System.out.print(TRY_COUNT.script);
    }
}
