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
    public void setUpGame() throws IllegalArgumentException {
        int size = setBridgeSize();
        bridgeGame = new BridgeGame();
        bridgeSelection = new BridgeSelection();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> makingBridge = bridgeMaker.makeBridge(size);
        bridge = new Bridge(size, makingBridge);
        trial++;
    }

    public void startGame() {
        try {
            inputView.printStartGame();
            setUpGame();
            progressMoving();
            quitGame(trial);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public int setBridgeSize() throws IllegalArgumentException {
        String input = inputView.readBridgeSize();
        int size = Validator.convertNumeric(input);
        Validator.validateBridgeSize(size);
        return size;
    }

    public String setMoving() throws IllegalArgumentException {
        System.out.println();
        String input = inputView.readMoving();
        Validator.checkUpOrDown(input);
        return input;
    }

    public String setRetryOrQuit() throws IllegalArgumentException {
        System.out.println();
        String input = inputView.readGameCommand();
        Validator.checkRetryOrQuit(input);
        return input;
    }


    public void progressMoving() throws IllegalArgumentException {
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

    public void selectRetryOrQuit() throws IllegalArgumentException {
        String decision = setRetryOrQuit();
        if (decision.equals("R")) {
            trial++;
            bridgeSelection = new BridgeSelection();
            progressMoving();
        }
    }

    public String checkFinishLine() {
        List<List<String>> selections = bridgeSelection.getSelections();
        return bridgeGame.retry(selections);
    }

    public void quitGame(int trial) {
        String gameResult = checkFinishLine();
        outputView.printResult(bridgeSelection.getSelections(),gameResult,trial);
    }
}
