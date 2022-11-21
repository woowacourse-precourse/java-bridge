package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static OutputView output = new OutputView();
    static InputView input = new InputView();
    static BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bg = new BridgeGame();

    private static int progress = 0, numTrial = 0;
    private static boolean retry = true, correct = true;

    public static void main(String[] args) {
        List<String> moves = new ArrayList<>();
        output.printStart();
        try {
            List<String> bridge = bm.makeBridge(input.readBridgeSize());
            moves = runGame(bridge, moves);
            output.printResult(correct, numTrial, output.makeMap(bridge, moves));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    public static List<String> runGame(List<String> bridge, List<String> moves) {
        try {
            while (retry && progress < bridge.size()) {
                moves = runTrial(bridge, moves);
                numTrial++;
                retry = runRetry(correct);
            }
            return moves;
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        } return moves;
    }
    public static boolean runRetry(boolean correct) {
        if (!correct) {
            return bg.retry(input.readGameCommand());
        }
        return false;
    }
    public static List<String> runTrial(List<String> bridge, List<String> moves) {
        correct = true;
        progress = 0;
        moves = new ArrayList<>();
        while (correct && progress < bridge.size()) {
            String move = input.readMoving();
            moves.add(move);
            output.printMap(output.makeMap(bridge, moves));
            correct = bg.move(bridge.get(progress),move);
            progress++;
        }
        return moves;
    }
}
