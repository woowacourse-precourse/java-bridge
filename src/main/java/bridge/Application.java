package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputview = new InputView();
        int size = inputview.readBridgeSize();
        BridgeMaker bm = new BridgeMaker(new BridgeNumberGenerator() {
            @Override
            public int generate() {
                BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
                return bng.generate();
            }
        });
        OutputView ov = new OutputView();
        List<String> list;
        while (true) {
            list = bm.makeBridge(size);
            boolean startAgain = ov.printResult(list);
            System.out.println(startAgain);
            if (!startAgain) {
                ov.gameEnded(list);
                break;
            }
            System.out.println("OUT");
        }

    }
}

