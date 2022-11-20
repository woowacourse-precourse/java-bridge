package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import bridge.util.Commands;
import java.util.List;

public class Processor {

    private static final String UP = "U" ;
    private static final String DOWN = "D" ;
    private final OutputView output;
    private final InputView input;

    Processor() {
        this.output = new OutputView();
        this.input = new InputView(output);
    }

    List<String> startGame() {
        output.printStartMessage();
        return getBridge();
    }

    private List<String> getBridge() {
        int bridgeSize;
        BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        do {
            bridgeSize = input.readBridgeSize();
        } while (bridgeSize == -1);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    String askMoving(){
        String moving;
        do{
            moving = input.readMoving();
        }while (moving.equals("error"));
        return moving ;
    }

    String askContinue(){
        String choice;
        do{
            choice = input.readContinue();
        }while (choice.equals("error"));
        return choice ;
    }

    void getRoundResult(String upsideBridge, String downsideBridge){
        output.printMap(upsideBridge, downsideBridge);
    }

    void getGameResult(boolean isComplete, int attempts, PlayerBoard playerBoard) {
        output.printMessage(Commands.FINAL_RESULT_MESSAGE.message());
        String upsideBridge = playerBoard.getBridgeStatus(UP);
        String downsideBridge = playerBoard.getBridgeStatus(DOWN);
        output.printMap(upsideBridge, downsideBridge);
        output.printResult(isComplete, attempts);
    }
}