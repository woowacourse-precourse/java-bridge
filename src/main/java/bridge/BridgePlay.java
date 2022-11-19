package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgePlay {

    private final InputView inputView;

    private final OutputView outputView;

    private final BridgeMaker bridgeMaker;

    private final ValidationUtil validationUtil;

    public BridgePlay() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        validationUtil = new ValidationUtil();
    }

    public void play() {
        outputView.printStartMessage();
        int bridgeLength = getBridgeLength();
        outputView.printPlayerMoveMessage();
        String playerMove = getPlayerMove();
    }

    private int getBridgeLength() {
        String userInput = inputView.readBridgeLength();
        int bridgeLength = 0;
        try {
            bridgeLength = validationUtil.validateBridgeLength(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getBridgeLength();
        }
        return bridgeLength;
    }

    private String getPlayerMove() {
        String userInput = inputView.readMoving();
        try {
            validationUtil.validatePlayerMoveInput(userInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getPlayerMove();
        }
        return userInput;
    }
}
