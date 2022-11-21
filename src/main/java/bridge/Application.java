package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size, try_count = 1;
        String move, re = "R";
        boolean success = true;

        Announcement.start();
        size = InputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

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
        // TODO: 프로그램 구현
    }
}
