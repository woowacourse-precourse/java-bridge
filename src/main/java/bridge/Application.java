package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size, try_count = 1;
        String move, re = "R";
        boolean success = true;

        Announcement.start();
        size = InputView.readBridgeSize();

        List<String> bridge = make_bridge(size);

        while(re.contains("R")) {
            for (int i = 0; i < size; i++) {
                Announcement.move();
                move = InputView.readMoving();
                success = BridgeGame.move(bridge, move, i);
                OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
                if (success == false)
                    break;
            }

            Announcement.restart();
            re = InputView.readGameCommand();

            if (re.contains("R")) {
                try_count += 1;
                BridgeGame.retry();
            }
        }

        Announcement.bridge_result();
        OutputView.printMap(BridgeGame.getUp_bridge(), BridgeGame.getDown_bridge());
        OutputView.printResult(success, try_count);
        // TODO: 프로그램 구현
    }
    public static List<String> make_bridge(int size){
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);
        return bridge;
    }
}
