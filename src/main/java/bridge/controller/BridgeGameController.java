package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private static String bridgeLength;
    private static int bridgeLengthInt;
    private static List<Integer> bridgeUpDown;


    public static void execute() {
        OutputView.printGameStartMessage();
        bridgeLength = InputView.readBridgeSize();
        InputView.validateBridgeLength(bridgeLength);
        bridgeLengthInt = Integer.parseInt(bridgeLength);
        InputView.validateBridgeLengthRange(bridgeLengthInt);
        executeBridgeGame();
    }

    public static void executeBridgeGame() {
        //정보를 가진 다리를 생성하기
        bridgeUpDown = BridgeGame.generateUpDownInformation(bridgeLengthInt);
    }
}
