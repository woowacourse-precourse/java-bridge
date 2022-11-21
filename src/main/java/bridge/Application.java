package bridge;

import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        try {
            System.out.println(GAME_START_MESSAGE);
            BridgeGame bridgeGame = new BridgeGame(makeBridge());
            startGame(bridgeGame);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startGame(BridgeGame bridgeGame) {
        do {
            bridgeGame.retry();
            play(bridgeGame);
        } while (userWantedReplaying(bridgeGame.getStatus()));
    }

    private static void play(BridgeGame bridgeGame) {
        while (bridgeGame.getStatus() == Status.PLAYING) {
            String userWantedDirection = inputView.readMoving();
            bridgeGame.move(userWantedDirection);
            outputView.printMap(bridgeGame);
        }
    }

    private static boolean userWantedReplaying(Status status) {
        //다리 끝까지 와서 게임이 끝난경우
        if (status == Status.ENDING) return false;

        String wantedDirection = inputView.readGameCommand();
        return wantedDirection.equals("R");
    }

    private static List<String> makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

}
