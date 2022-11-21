package bridge;

import java.util.List;

public class Application {
    private static final InputView receiver = new InputView();
    private static final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public static void main(String[] args) {
        System.out.printf(Constants.Messages.START.getMessage());
        BridgeGame bridgeGame = createBridge();
        OutputView printer = bridgeGameUI(bridgeGame);

    }

    // 다리를 생성
    private static BridgeGame createBridge() {
        int size = bridgeSizeUI();
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        return bridgeGame;
    }

    // 다리 생성 UI : 부적절한 문자가 입력될 시, 다시 입력을 받을 준비
    private static int bridgeSizeUI() {
        System.out.printf(Constants.Messages.BRIDGE.getMessage());
        while (true) {
            try {
                return receiver.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    // 이동 선택 UI : 부적절한 문자가 입력될 시, 다시 입력을 받을 준비
    private static String moveChoiceUI() {
        System.out.printf(Constants.Messages.MOVE.getMessage());
        while (true) {
            try {
                return receiver.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    // 다리 게임 한판
    private static OutputView bridgeGameUI(BridgeGame bridgeGame) {
        OutputView printer = new OutputView();
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            if (!bridgeGame.move(moveChoiceUI(), i)) {
                printBadMove(bridgeGame.getBridge(), i, printer);
                break;
            }
            printGoodMove(bridgeGame.getBridge(), i, printer);
        }
        return printer;
    }

    private static void printBadMove(List<String> bridge, int index, OutputView printer) {
        printer.mapBuilder(false, index, bridge);
        printer.printMap();
    }

    private static void printGoodMove(List<String> bridge, int index, OutputView printer) {
        printer.mapBuilder(true, index, bridge);
        printer.printMap();
    }
}
