package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class Processor {

    private final OutputView output;
    private final InputView input;

    Processor() {
        this.output = new OutputView();
        this.input = new InputView(output);
    }

    public List<String> startGame() {
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

    public String askMoving(){
        String moving;
        do{
            moving = input.readMoving();
        }while (moving.equals("error"));
        return moving ;
    }

    public String askContinue(){
        String choice;
        do{
            choice = input.readContinue();
        }while (choice.equals("error"));
        return choice ;
    }

    public void getRoundResult(String upsideBridge, String downsideBridge){
        output.printMap(upsideBridge, downsideBridge);
    }

    public void getGameResult(boolean isComplete, int attempts, PlayerBoard playerBoard) {
        output.printResult(isComplete, attempts, playerBoard);
    }
}