package bridge;

public class Application {
    static int bridgeLength;

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printAppInst();
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        // should manage error and new bridge here
        BridgeMaker newBridge = new BridgeMaker(generator);

        bridgeLength = InputView.readBridgeSize();

        newBridge.makeBridge(bridgeLength);
        BridgeGame newGame = new BridgeGame();
        newGame.move(bridgeLength, newGame);

//        System.out.println("최종 게임 결과");
//        System.out.println("[ O |   | O ]");
//        System.out.println("[   | O |   ]");
//        System.out.println("게임 성공 여부: 성공");
//        System.out.println("총 시도한 횟수: 1");
    }

    public static int getBridgeLength(BridgeNumberGenerator generator) {
        try {
            BridgeMaker newBridge = new BridgeMaker(generator);
            bridgeLength = InputView.readBridgeSize();
//        System.out.println("this is bridge length"+bridgeLength);
            return bridgeLength;

        } catch (IllegalArgumentException e) {
            return getBridgeLength(generator);
        }
    }


    public static void printAppInst() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
//        System.out.println();
    }
}
