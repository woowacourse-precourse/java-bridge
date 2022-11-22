package bridge;

import java.util.List;

public class GameController {
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private Bridge bridge;
    private BridgeSelection bridgeSelection;
    private int trial = 0;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void setUpGame() {
        bridgeGame = new BridgeGame();
        bridgeSelection = new BridgeSelection();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(setBridgeSize());
        trial++;
    }

    public void startGame() {
        inputView.printStartGame();
        setUpGame();
        progressMoving();
        quitGame(trial);
    }

    public int setBridgeSize() {
        try {
            String input = inputView.readBridgeSize();
            int size = Validator.convertNumeric(input);
            Validator.validateBridgeSize(size);
            return size;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return 0;
    }

    public String setMoving() {
        try {
            System.out.println();
            String input = inputView.readMoving();
            Validator.checkUpOrDown(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public String setRetryOrQuit() {
        try {
            System.out.println();
            String input = inputView.readGameCommand();
            Validator.checkRetryOrQuit(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }


    public void progressMoving() {
        for (int index=0; index < bridge.getSize(); index++) {
            String selection = setMoving();
            boolean matchMark = bridge.compare(index, selection);
            checkMoving(matchMark, selection);
            if (!matchMark) {
                selectRetryOrQuit();
                break;
            }
        }
    }

    public void checkMoving(boolean matchMark, String selection) {
        List<List<String>> selections = bridgeSelection.insertBridgeSelection(bridgeGame.move(matchMark), selection);
        bridgeSelection.setSelections(selections);
        outputView.printMap(bridgeSelection.getSelections());
    }

    public void selectRetryOrQuit() {
        String decision = setRetryOrQuit();
        if (decision.equals("R")) {
            trial++;
            bridgeSelection = new BridgeSelection();
            progressMoving();
        }
    }

    public String checkFinishLine() {
        List<List<String>> selections = bridgeSelection.getSelections();
        for (List<String> selection : selections) {
            if (selection.contains("X")) {
                return "실패";
            }
        }
        return "성공";
    }

    public void quitGame(int trial) {
        String gameResult = checkFinishLine();
        outputView.printResult(bridgeSelection.getSelections(),gameResult,trial);
    }
}
