package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeStatusSaver;
import bridge.domain.BridgeUpDownGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    private static String bridgeLength;
    private static int bridgeLengthInt;
    private static List<String> bridgeUpDown;
    private static String upBridge;
    private static String downBridge;
    private static int numberOfGamePlay = 1;

    public static void execute() {
        beforeGameStart();
        BridgeStatusSaver bridgeStatusSaver = new BridgeStatusSaver(new ArrayList<>(), bridgeUpDown);
        BridgeGame bridgeGame = new BridgeGame(bridgeStatusSaver, numberOfGamePlay);
        executeBridgeGame(bridgeGame);
    }

    public static void beforeGameStart() {
        OutputView.printGameStartMessage();
        bridgeLength = InputView.readBridgeSize();
        InputView.validateBridgeLength(bridgeLength);
        bridgeLengthInt = Integer.parseInt(bridgeLength);
        InputView.validateBridgeLengthRange(bridgeLengthInt);
        bridgeUpDown = BridgeUpDownGenerator.generateUpDownInformation(bridgeLengthInt);
    }

    public static void executeBridgeGame(BridgeGame bridgeGame) {

    }
}


