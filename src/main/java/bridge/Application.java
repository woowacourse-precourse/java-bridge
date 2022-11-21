package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static OutputView output = new OutputView();
    static InputView input = new InputView();
    static BridgeNumberGenerator bng = new BridgeRandomNumberGenerator();
    static BridgeMaker bm = new BridgeMaker(bng);
    static BridgeGame bg = new BridgeGame();

    public static void main(String[] args) {
        output.printStart();
        List<String> bridge = bm.makeBridge(input.readBridgeSize());
        List<String> moves = new ArrayList<>();
        System.out.println(bridge);
        boolean retry = true, correct = true;
        int progress = 0;
        while (retry) {
            while (correct) {
                String move = input.readMoving();
                moves.add(move);
                progress++;
                output.printMap(output.makeMap(bridge, moves));
                correct = bg.move(bridge.get(progress),move);
            }
            retry = bg.retry(input.readGameCommand());
        }
    }
}
