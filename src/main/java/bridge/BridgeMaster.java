package bridge;

import View.InputView;
import View.OutputView;
import java.util.List;
import data.InputGuide;

public class BridgeMaster {
    BridgeRandomNumberGenerator tempGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(tempGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    void startGame(){
        boolean isSuccess = false;
        int attempt = 0;
        List<String> bridge = constructBridge();
        isSuccess = crossBridge(bridge);
        printResult();
        printAttempt();
    }

    private List<String> constructBridge(){
        InputGuide.printWelcomeMessage();
        int size = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private boolean crossBridge(List<String> bridge){
        boolean isCorrect = true;
        int bridgePieceCount = 0;
        while(bridgePieceCount != bridge.size()){
            String bridgePiece = bridge.get(bridgePieceCount);
            isCorrect = bridgeGame.move(bridgePiece, inputView.readMoving());
            outputView.printMap(bridge, isCorrect, bridgePieceCount++);
        }
        return true;
    }

    private boolean printResult(){
        return false;
    }

    private void printAttempt(){

    }
}
