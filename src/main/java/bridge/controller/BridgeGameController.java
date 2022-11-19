package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.dto.request.BridgeSizeRequestDto;
import bridge.service.dto.request.PlayerMovementRequestDto;
import bridge.service.dto.response.BridgeStateResponseDto;
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
    }

    private void createBridge() {
        BridgeSizeRequestDto dto = inputView.readBridgeSize();
        bridgeGame.create(dto);
    }

    private void play() {
        while (true) {
            PlayerMovementRequestDto requestDto = inputView.readMoving();
            BridgeStateResponseDto responseDto = bridgeGame.move(requestDto);
            outputView.printMap(responseDto);
        }
    }
}
