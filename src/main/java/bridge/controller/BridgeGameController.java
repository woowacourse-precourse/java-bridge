package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;


public class BridgeGameController {
    private BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final OutputView output = new OutputView();
    private final InputView input = new InputView();
    private final BridgeGame bg = new BridgeGame();

    private int progress = 0, numTrial = 0;
    private boolean retry = true, correct = true;
    private List<String> moves = new ArrayList<>();

    public void run() {
        output.printStart();
        try {
            List<String> bridge = bm.makeBridge(input.readBridgeSize());
            runGame(bridge, moves);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    public void runGame(List<String> bridge, List<String> moves) {
        try {
            while (retry && progress < bridge.size()) {
                moves = runTrial(bridge);
                numTrial++;
                retry = runRetry(correct);
                output.printResult(correct, numTrial, output.makeMap(bridge, moves));
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
    public boolean runRetry(boolean correct) {
        if (!correct) {
            return bg.retry(input.readGameCommand());
        }
        return false;
    }
    public List<String> runTrial(List<String> bridge) {
        setup();
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
    public void setup() {
        correct = true;
        progress = 0;
    }
}
