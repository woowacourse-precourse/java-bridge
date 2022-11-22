package bridge;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private final Bridge bridge;
    private final BridgeGame bridgeGame;

    public OutputView(Bridge bridge, BridgeGame bridgeGame) {
        this.bridge = bridge;
        this.bridgeGame = bridgeGame;
    }

    public void printMap() {
        System.out.println(bridge.toString());
    }

    public void printResult() {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap();
        System.out.println(GAME_SUCCESS_MESSAGE + bridge.getGameResultString());
        System.out.println(TRY_COUNT_MESSAGE + bridgeGame.getTryCount());
    }
}
