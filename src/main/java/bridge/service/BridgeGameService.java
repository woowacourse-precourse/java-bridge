package bridge.service;

import static bridge.exception.Error.*;
import static bridge.view.OutputView.*;

import bridge.domain.Round;
import bridge.domain.RoundResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;
import java.util.Objects;

public class BridgeGameService {

    private BridgeGame bridgeGame;

    public void execute() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        printBridgeGameStartMessage();

        try {
            initializeBridgeGameByBridgeSize(inputView.readBridgeSize());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NOT_INT.getMessage());
        }

        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            bridgeGame.move(inputView.readMoving());
        }

    }

    private void initializeBridgeGameByBridgeSize(int size) {
        bridgeGame = new BridgeGame(size);
    }


}
