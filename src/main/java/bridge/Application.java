package bridge;

import java.util.List;

public class Application {
    static InputView iv = new InputView();
    static OutputView ov = new OutputView();
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        List<String> list;
        int size = iv.readBridgeSize();
        BridgeMaker bm = generateBridgeMaker();
        while (true) {
            list = bm.makeBridge(size);
            if (!ov.printMap(list)) break;
        }
        ov.printResult(list);
    }

    public static BridgeMaker generateBridgeMaker(){
        return new BridgeMaker(new BridgeNumberGenerator() {
            @Override
            public int generate() {
                BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
                return bng.generate();
            }
        });
    }
}

