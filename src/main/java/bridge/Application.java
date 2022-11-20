package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        gameStart();
        makeBridge();
    }

    public static void gameStart() {
        System.out.println(OutputView.printGameStartPhrase());
        System.out.println();
        System.out.println(OutputView.printBridgeLengthInputPhrase());
    }

    public static void makeBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeMaker.makeBridge(InputView.readBridgeSize());
    }
}
