package bridge;

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

        List<String> list = bm.makeBridge(size);
        OutputView ov = new OutputView();
        for (int i = 0; i < list.size(); i++) {
            String choice = inputview.readMoving();
            if (!ov.printMap(i, list, choice)) {
                System.out.println("\n");
                break;
            }
        }
    }
}
