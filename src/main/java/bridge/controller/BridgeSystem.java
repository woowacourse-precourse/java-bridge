package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Command;
import bridge.domain.Results;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeSystem {
    private static final String OUTPUT_MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeSystem() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        System.out.println(OUTPUT_MESSAGE_GAME_START);
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge, new Results());
        play(bridgeGame);
        outputView.printResult(bridgeGame);
    }

    public void play(BridgeGame bridgeGame) {
        while(bridgeGame.isProcessing()){
            String userCommand = inputView.readMoving();
            bridgeGame.move(userCommand);
            outputView.printMap(bridgeGame.getResults());
            checkAlive(bridgeGame);
        }
        bridgeGame.setSuccessOrFail(GAME_SUCCESS);
    }

    public void checkAlive(BridgeGame bridgeGame) {
        if (!bridgeGame.isAlive()) {
            String gameCommand = inputView.readGameCommand();
            checkRetryOrQuit(bridgeGame, gameCommand);
        }
    }

    public void checkRetryOrQuit(BridgeGame bridgeGame, String gameCommand) {
        if (gameCommand.equals(Command.RETRY)) {
            bridgeGame.retry();
            return;
        }
        bridgeGame.setSuccessOrFail(GAME_FAIL);
    }
}
