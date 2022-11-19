package bridge.view;

public final class GuideView {

    private GuideView() {
    }

    public static void printGameStart() {
        print(GuideViewMessage.GAME_START.message);
        printNewLine();
    }

    public static void printGameResult() {
        print(GuideViewMessage.GAME_RESULT.message);
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static void printNewLine() {
        System.out.println();
    }

    private enum GuideViewMessage {
        GAME_START("다리 건너기 게임을 시작합니다"),
        GAME_RESULT("최종 게임 결과");

        private String message;

        GuideViewMessage(String message) {
            this.message = message;
        }
    }
}
