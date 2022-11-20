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
    static boolean success;
    static int tryCount = 0;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        getBridge();
        gameStart();
    }

    private static void getBridge() {
        getBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    private static void getBridgeSize() {
        bridgeSize = inputview.readBridgeSize();
    }

    private static void gameStart() {
        playerMove = new ArrayList<>();
        success = true;
        while(success){
            bridgeGame.move();
            success = CheckSuccess();
        }
    }

    private static boolean CheckSuccess() {
        int index = playerMove.size() - 1;
        String lastMove = playerMove.get(index);
        if(bridge.get(index).equals(lastMove))
            return true;
        return false;
    }
}
