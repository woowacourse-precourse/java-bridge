package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.model.MapMaker;
import bridge.util.Converter;
import bridge.util.Validator;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.util.ErrorCode.*;

public class BridgeGameController {
    private static final String UPSIDE = "U";
    private static final String DOWNSIDE = "D";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Validator validator = new Validator();
    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void run() {
        outputView.printStartMessage();
        getBridgeSizeInputAndStartGame();
    }

    private void startGame(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        getMovingInputAndMove(bridgeGame);
    }

    private void playGame(BridgeGame bridgeGame, String moving) {
        boolean moveSuccess = bridgeGame.move(moving);

        bridgeGame.updateRecords(moving, moveSuccess);
        List<String> uRecords = bridgeGame.getRecords(UPSIDE);
        List<String> dRecords = bridgeGame.getRecords(DOWNSIDE);

        MapMaker mapMaker = new MapMaker(uRecords, dRecords);
        String upsideMap = mapMaker.makeUpsideMap();
        String downsideMap = mapMaker.makeDownsideMap();
        outputView.printMap(upsideMap, downsideMap);
    }

    private void getBridgeSizeInputAndStartGame() {
        try {
            int bridgeSize = inputView.readBridgeSize();
            validateBridgeSize(bridgeSize);
            startGame(bridgeSize);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_BRIDGE_SIZE);
            getBridgeSizeInputAndStartGame();
        }
    }

    private void getMovingInputAndMove(BridgeGame bridgeGame) {
        try {
            String moving = inputView.readMoving();
            validateMoving(moving);
            playGame(bridgeGame, moving);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(INVALID_MOVING);
            getMovingInputAndMove(bridgeGame);
        }
    }

    private void validateBridgeSize(int size) {
        if (!validator.isValidRange(size)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMoving(String moving) {
        if (!validator.isValidMoving(moving)) {
            throw new IllegalArgumentException();
        }
    }
}