package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.GameRetryRequestDto;
import bridge.service.dto.request.SelectBlockRequestDto;
import bridge.service.dto.response.BridgeResponseDto;
import bridge.service.dto.response.GameResultResponseDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        outputView.printStart();
        createBridge();
        play();
        gameResult();
    }

    private void createBridge() {
        BridgeSizeRequestDto requestDto = inputView.readBridgeSize();
        bridgeGame.create(requestDto);
    }

    private void play() {
        bridgeGame.tryGame();
        while (!bridgeGame.gameOver()) {
            SelectBlockRequestDto requestDto = inputView.readMoving();
            BridgeResponseDto responseDto = bridgeGame.move(requestDto);
            outputView.printMap(responseDto);
        }

        gameRetry();
    }

    private void gameRetry() {
        if (bridgeGame.isFail()) {
            GameRetryRequestDto requestDto = inputView.readGameCommand();
            if (bridgeGame.retry(requestDto)) {
                play();
            }
        }
    }

    private void gameResult() {
        GameResultResponseDto responseDto = bridgeGame.result();
        outputView.printResult(responseDto);
    }
}
