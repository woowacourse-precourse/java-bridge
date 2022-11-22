package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> bridge;
    private List<String> player = new ArrayList<>();
    private String upResult = "";
    private String downResult = "";
    private int retryCount = 1;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean runGame() {
        InputView input = new InputView();
        OutputView printer = new OutputView();
        while (bridge.size() != player.size()) {
            String playerMove = input.readMoving();
            if (!move(playerMove)) {
                resultToString(playerMove, "X");
                printer.printMap(upResult, downResult);
                player.clear();
                if (retry(input.readGameCommand())) {
                    upResult = "";
                    downResult = "";
                    retryCount++;
                    continue;
                }
                printer.printResult(upResult, downResult);
                return false;
            }
            resultToString(playerMove, "O");
            printer.printMap(upResult, downResult);
        }
        printer.printResult(upResult, downResult);
        return true;
    }

    public boolean move(String playerInput) {
        player.add(playerInput);
        return bridge.get(player.size() - 1).equals(playerInput);
    }

    public void resultToString(String playerInput, String result) {
        if (playerInput.equals("U")) {
            upResult += result;
            downResult += " ";
        }
        if (playerInput.equals("D")) {
            upResult += " ";
            downResult += result;
        }
    }

    public boolean retry(String userInput) {
        return userInput.equals("R");
    }

    public int getRetryCount() {
        return retryCount;
    }
}
