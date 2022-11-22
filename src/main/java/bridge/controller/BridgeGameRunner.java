package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Status;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.constants.Constants.GAME_COMMAND_QUIT;
import static bridge.constants.Constants.GAME_START_MESSAGE;

public class BridgeGameRunner {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public void run() {
        System.out.println(GAME_START_MESSAGE);
        BridgeGame bridgeGame = new BridgeGame(makeBridge());
        startGame(bridgeGame);
    }

    private void startGame(BridgeGame bridgeGame) {
        while (true) {
            play(bridgeGame);
            if (userWantedQuit(bridgeGame.getStatus())) {
                break;
            }
            bridgeGame.retry();
        }
        outputView.printResult(bridgeGame);
    }

    private void play(BridgeGame bridgeGame) {
        while (bridgeGame.getStatus() == Status.PLAYING) {
            String userWantedDirection = inputView.readMoving();
            bridgeGame.move(userWantedDirection);
            outputView.printMap(bridgeGame);
        }
    }

    private boolean userWantedQuit(Status status) {
        //다리 끝까지 와서 게임이 끝난경우(유저의 입력을 받지 않고 종료 시킨다)
        if (status == Status.ENDING) {
            return true;
        }

        String wantedDirection = inputView.readGameCommand();
        return wantedDirection.equals(GAME_COMMAND_QUIT);
    }

    private List<String> makeBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

}
