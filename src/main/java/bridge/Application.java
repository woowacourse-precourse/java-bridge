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
        System.out.println(bridge);
        List<String> moves = new ArrayList<>();;
        int progress = 0;
        int numTrial = 0;
        boolean retry = true, correct = true;
        while (retry && progress < bridge.size()) {
            progress = 0;
            moves = new ArrayList<>();
            while (correct && progress < bridge.size()) {
                String move = input.readMoving();
                moves.add(move);
                output.printMap(output.makeMap(bridge, moves));
                correct = bg.move(bridge.get(progress),move);
                progress++;
            }
            numTrial++;
            if (!correct) {
                retry = bg.retry(input.readGameCommand());
            }
        }
        output.printResult(correct, numTrial, output.makeMap(bridge, moves));

    }
}
