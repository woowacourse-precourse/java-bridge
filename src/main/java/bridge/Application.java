package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputview = new InputView();
        OutputView ov = new OutputView();
        List<String> list;
        int size = inputview.readBridgeSize();

        BridgeMaker bm = new BridgeMaker(new BridgeNumberGenerator() {
            @Override
            public int generate() {
                BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
                return bng.generate();
            }
        });

        while (true) {
            list = bm.makeBridge(size);
            if (!ov.printMap(list)) break;
        }
        ov.printResult(list);
    }
}

