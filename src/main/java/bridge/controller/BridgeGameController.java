package bridge.controller;

import bridge.BridgeMaker;
import bridge.controller.validator.BridgeGameControllerValidator;
import bridge.domain.*;
import bridge.dto.BridgeGameResultDto;
import bridge.dto.BridgeGameLocationDto;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Bridge bridge;
    private int triedCount;

    public BridgeGameController(final InputView inputView, final OutputView outputView, final BridgeMaker bridgeMaker) {
        BridgeGameControllerValidator.validate(inputView, outputView, bridgeMaker);
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridge = initBridge(bridgeMaker);
    }
}