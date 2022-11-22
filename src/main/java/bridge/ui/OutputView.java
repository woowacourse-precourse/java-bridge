package bridge.ui;

public class OutputView {
    private static final String START_GAME_ANNOUNCEMENT = "다리 건너기 게임을 시작합니다.";
    private static final String END_GAME_ANNOUNCEMENT = "최종 게임 결과";
    private static final String SUCCESS_GAME_ANNOUNCEMENT = "게임 성공 여부: 성공";
    private static final String FAIL_GAME_ANNOUNCEMENT = "게임 성공 여부: 실패";
    private static final String TRY_COUNT_ANNOUNCEMENT_FORMAT = "총 시도한 횟수: %d";
    private static final String NO_LETTER = "";

    public void announceStartGame() {
        System.out.println(START_GAME_ANNOUNCEMENT);
        System.out.println(NO_LETTER);
    }

    public void printMap(String bridgePicture) {
        System.out.println(bridgePicture);
        System.out.println(NO_LETTER);
    }

    public void printResult(boolean isSuccess, int tryCount) {
        if (isSuccess) {
            System.out.println(SUCCESS_GAME_ANNOUNCEMENT);
        }
        if (!isSuccess) {
            System.out.println(FAIL_GAME_ANNOUNCEMENT);
        }
        System.out.printf(TRY_COUNT_ANNOUNCEMENT_FORMAT, tryCount);
    }

    public void announceEndGame() {
        System.out.println(END_GAME_ANNOUNCEMENT);
    }
}
