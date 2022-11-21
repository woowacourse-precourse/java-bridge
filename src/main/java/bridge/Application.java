package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int size;
        String move;
        Announcement.start();
        size = InputView.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(size);

        for(int i=0;i<size;i++){
            Announcement.move();
            move = InputView.readMoving();
        }
        // TODO: 프로그램 구현
    }
}
