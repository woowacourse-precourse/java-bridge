package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int size = 0;

    public static void main(String[] args) {
//        System.out.println("다리 건너기 게임을 시작합니다.");
//        size = InputView.readBridgeSize();
//        BridgeMaker.makeBridge(size);
//        System.out.println(BridgeGame.move(InputView.readMoving()));
//        BridgeGame.retry(InputView.readGameCommand());
//        OutputView.printMap(moving);
//        OutputView.printResult(1,4);
        List<String> bridge = new ArrayList<>();
        bridge.add("D");
        bridge.add("U");
        bridge.add("U");
        List<String> userMoving = new ArrayList<>();
        userMoving.add("D");
        userMoving.add("U");
        userMoving.add("D");
        OutputView.printMap(bridge,userMoving);
    }
}
