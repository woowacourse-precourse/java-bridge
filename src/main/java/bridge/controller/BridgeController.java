package bridge.controller;

import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeService bridgeService = new BridgeService();
    private List<String> bridge = new ArrayList<>();
    private List<List<String>> upAndDown = new ArrayList<>();
    private boolean isMove = true;
    private int index = 0;
    private int attempt = 1;
    private String inputRetry;


    public void startGame() {
        int size = Integer.valueOf(inputView.readBridgeSize());
        this.bridge = bridgeService.bridgeMake(size);
    }

    public void playingGame() {
        playGame();
        if (isMove)
            successGame();
        else if (!isMove) {
            retryGame();
        }
    }

    private void playGame() {
        while (isMove && bridge.size() != index) {
            String inputMove = inputView.readMoving();

            isMove = bridgeService.isMove(inputMove, this.bridge);
            this.upAndDown = bridgeService.upAndDownProgress(inputMove, isMove);

            outputView.printMap(upAndDown.get(0), upAndDown.get(1));
            index++;
        }
    }

    private void retryGame() {
        this.inputRetry = inputView.readGameCommand();
        while (bridgeService.retryJudge(inputRetry)) {
            retryInit();
            playingGame();
            if (!bridgeService.retryJudge(inputRetry)) {
                failGame();
            }
        }
    }

    private void retryInit() {
        attempt++;
        index = 0;
        isMove = true;
    }

    private void failGame() {
        outputView.printResult(upAndDown.get(0), upAndDown.get(1));
        outputView.printFailResult(attempt);
    }
    
    private void successGame() {
        outputView.printResult(upAndDown.get(0), upAndDown.get(1));
        outputView.printSuccessResult(attempt);
        return;
    }
}
