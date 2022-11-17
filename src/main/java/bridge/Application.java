package bridge;

import java.util.List;
import java.util.Objects;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();
    static final String startGame = "다리 건너기 게임을 시작합니다.\n";
    static String input;
    static int count = 1;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(startGame);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        System.out.println();
        start(bridgeList, 0);
    }

    public static void start(List<String> bridgeList, int movingIndex) {
        if (Objects.equals(bridgeList.size(), movingIndex)) {
            printingResult(bridgeList, movingIndex - 1);
            return;
        }
        input = inputView.readMoving();
        outputView.printMap(movingIndex, bridgeList, input);
        if (requireGame(bridgeList, movingIndex)) return;
        start(bridgeList, movingIndex + 1);
    }

    private static boolean requireGame(List<String> bridgeList, int movingIndex) {
        if (bridgeGame.move(bridgeList.get(movingIndex), input)) {
            String Command = inputView.readGameCommand();
            if (bridgeGame.retry(Command)) {
                count++;
                start(bridgeList, 0);
                return true;
            }
            printingResult(bridgeList, movingIndex);
            return true;
        }
        return false;
    }

    private static void printingResult(List<String> bridgeList, int movingIndex) {
        outputView.printResult(movingIndex, bridgeList, input);
        outputView.printResult(count);
    }
}
