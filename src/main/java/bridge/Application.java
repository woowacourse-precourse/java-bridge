package bridge;

import bridge.controller.BridgeGame;
import bridge.view.InputView;

public class Application {
    public static int bridgeLength;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        start();
    }

    public static void start() {
        printAppInst();

        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker newBridge = new BridgeMaker(generator);

        createBridgeAndGame(newBridge);
    }

    public static void createBridgeAndGame(BridgeMaker newBridge) {
        bridgeLength = InputView.readBridgeSize();

        newBridge.makeBridge(bridgeLength);
        BridgeGame newGame = new BridgeGame();

        newGame.move(bridgeLength, newGame);
    }

    public static void printAppInst() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }
}
