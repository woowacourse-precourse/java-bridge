package bridge.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String FINAL_GAME_RESULT_MESSAGE = "\n최종 게임 결과\n%s";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printMap(String map) {
        System.out.println(map);
    }

    public void printResult(String resultGame) {
        System.out.printf(FINAL_GAME_RESULT_MESSAGE, resultGame);
    }
}
