package bridge.ui;

public class OutputView {
    private static final String START_GAME_ANNOUNCEMENT = "다리 건너기 게임을 시작합니다.\n";
    private static final String END_GAME_ANNOUNCEMENT = "최종 게임 결과";
    private static final String SUCCESS_GAME_ANNOUNCEMENT = "게임 성공 여부: 성공";
    private static final String FAIL_GAME_ANNOUNCEMENT = "게임 성공 여부: 실패";
    private static final String TRY_COUNT_ANNOUNCEMENT = "총 시도한 횟수: %d";

    public void announceStartGame() {
        System.out.println(START_GAME_ANNOUNCEMENT);
    }

    public void printMap(String bridgePicture) {
        System.out.println(bridgePicture);
        System.out.println();
    }

    public void printResult(boolean isSuccess, int tryCount) {
        if (isSuccess) {
            System.out.println(SUCCESS_GAME_ANNOUNCEMENT);
        }
        if (!isSuccess) {
            System.out.println(FAIL_GAME_ANNOUNCEMENT);
        }
        System.out.printf(TRY_COUNT_ANNOUNCEMENT, tryCount);
    }

    public void announceEndGame() {
        System.out.println(END_GAME_ANNOUNCEMENT);
    }
}
