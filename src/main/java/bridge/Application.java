package bridge;

import java.util.List;
import java.util.ArrayList;

public class Application {
    static int bridgeSize;
    static List<String> bridge;
    static List<String> playerMove;
    static InputView inputview = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        GetBridge();
        GameStart();
    }

    private static void GetBridge() {
        GetBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private static void GetBridgeSize() {
        bridgeSize = inputview.readBridgeSize();
    }

    private static void GameStart() {
        playerMove = new ArrayList<>();
        while(true){
            String move = inputview.readMoving();
            CheckMove(move);
        }
    }

    private static void CheckMove(String move) {
        playerMove.add(move);
    }
}
