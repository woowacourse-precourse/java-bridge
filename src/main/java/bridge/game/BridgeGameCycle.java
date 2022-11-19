package bridge.game;

import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;

import java.util.List;

import static bridge.enums.IntEnum.*;
import static bridge.enums.StringEnum.*;
import static bridge.view.OutputView.*;

public class BridgeGameCycle {
    private static final boolean CONTINUE = true;
    private static final boolean FINISH = false;
    private static final InputView inputView = new InputView();
    private int coin = 1;
    private int bridgeLength;
    private int nowState;
    private String finalMap;


    public void play() throws IllegalArgumentException {


    }

    private void beforeGame() {
        printGameStart();
        printAskLength();
        bridgeLength = inputView.readBridgeSize();
    }

    private void oneTurnCycle(BridgeGame game) {
        printAskMoving();
        String inputMoving = inputView.readMoving();
        nowState = game.move(inputMoving);
        finalMap = game.nowBridgeStage(nowState);
        printMap(finalMap);
    }

    private String askInputCommand() {
        printAskCommand();
        String inputCommand = inputView.readGameCommand();
        return inputCommand;
    }

}
