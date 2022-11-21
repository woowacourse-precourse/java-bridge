package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    private BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private BridgeSelection bridgeSelection;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void startGame() {
        try {
            inputView.printStartGame();
            List<String> bridge = setBridgeSize();
            System.out.println(bridge);
            checkMoving(bridge);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }//7
    }

    public List<String> setBridgeSize() throws IllegalArgumentException {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        String input = inputView.readBridgeSize();
        int size = Validator.convertNumeric(input);
        Validator.validateBridgeSize(size);
        bridgeSelection = new BridgeSelection(size);
        return bridgeMaker.makeBridge(size);
    }

    public String setMoving() throws IllegalArgumentException {
            String input = inputView.readMoving();
            Validator.checkUpOrDown(input);
        return input;
    }

    public void checkMoving(List<String> bridge) {
        bridgeGame = new BridgeGame();
        for (int index=0; index < bridgeSelection.getSize(); index++) {
            String selection = setMoving();
            String result = bridgeGame.move(selection, bridge.get(index));
            bridgeSelection.setSelections(bridgeSelection.insertBridgeSelection(result, selection));
            outputView.printMap(bridgeSelection.getSelections());
        }
    }
}
