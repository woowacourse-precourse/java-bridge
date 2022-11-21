package bridge;

import java.util.List;

import static constants.Constants.*;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

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
        while(true){
            play(bridgeGame);
            if(userWantedQuit(bridgeGame.getStatus())){
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    private static void play(BridgeGame bridgeGame) {
        while (bridgeGame.getStatus() == Status.PLAYING) {
            String userWantedDirection = inputView.readMoving();
            bridgeGame.move(userWantedDirection);
            outputView.printMap(bridgeGame);
        }
    }

    private static boolean userWantedQuit(Status status) {
        //다리 끝까지 와서 게임이 끝난경우
        if (status == Status.ENDING) {
            return true;
        }

        String wantedDirection = inputView.readGameCommand();
        return wantedDirection.equals(GAME_COMMAND_QUIT);
    }

    private static List<String> makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

}
