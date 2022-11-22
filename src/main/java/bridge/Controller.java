package bridge;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;
    public int count = 1;

    public Controller() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    private int makeBridge() {
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        this.bridgeGame = new BridgeGame(bridge);
        return size;
    }

    private String isCorrect(String correct) {
        if (correct.contains("C"))
            return OutputView.Message.SUCCESS.get();
        return OutputView.Message.FAILURE.get();
    }

    private Boolean isQuit(String correct, List<String> current_status) {
        if (correct.equals(OutputView.Message.FAILURE.get())) {
            return retry(inputView.readGameCommand(), current_status);
        }
        return true;
    }

    private boolean retry(String command, List<String> current_status) {
        if (command.equals("R")) {
            this.count++;
            current_status.clear();
            return true;
        }
        return false;
    }

    private String RoundGame(int size, List<String> current_status) {
        String correct = "0";
        while (current_status.size() < size) {
            String move = inputView.readMoving();
            correct = bridgeGame.move(current_status.size(), move);
            current_status.add(correct);
            outputView.printMap(current_status);
            boolean quit = isQuit(isCorrect(correct), current_status);
            if (!quit) break;
        }
        return correct;
    }

    public void bridgeGame() {
        int size;
        List<String> current_status = new ArrayList<>();
        outputView.printStart();
        size = makeBridge();
        String correct = RoundGame(size, current_status);
        outputView.printResult(current_status, count, isCorrect(correct));
    }
}
