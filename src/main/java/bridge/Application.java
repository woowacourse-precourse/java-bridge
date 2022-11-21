package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printStart();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridgeSize, bridge);

        System.out.println(bridge);
        playGame(bridgeGame, inputView);

    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public static void printFailEnd(BridgeGame bridgeGame) {
        // 함수로 성공, 실패 함수 합치는거 고민해보기
        System.out.println("게임 성공 여부: 실패");
        System.out.println(String.format("총 시도한 횟수: %d", bridgeGame.getTryCount()));
    }

    public static void playGame(BridgeGame bridgeGame, InputView inputView) {
        while (!bridgeGame.isEndGame()) {
            if (move(bridgeGame, inputView)) {
                break;
            }
        }
    }

    public static boolean move(BridgeGame bridgeGame, InputView inputView) {
        int currentLocation = bridgeGame.move(inputView.readMoving());
        if (currentLocation == -1) {
            if (!bridgeGame.isRetry(inputView.readGameCommand())) {
                printFailEnd(bridgeGame);
                return true;
            }
        }
        return false;
    }

    public static void printCurrent() {

    }
}
