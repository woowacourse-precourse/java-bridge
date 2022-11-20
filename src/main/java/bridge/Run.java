package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.OutputView.*;

public class Run {
    public Run(){
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();

        outputView.printMessage(gameStartMessage);
        outputView.printMessage(inputBridgeLengthMessage);
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        String gameResult = failMessage;
        boolean retryResult = true;
        int cntTries=0;
        List <String> saveTotalMove = new ArrayList<>();
        while(!((!retryResult && gameResult.equals(failMessage)) || gameResult.equals(successMessage))) {
            int curLocation;
            cntTries++;
            List <String> totalMove = new ArrayList<>();
            for (curLocation = 0; curLocation < bridgeSize; curLocation++) {
                outputView.printMessage(selectUpDownMessage);
                String selectedMove = inputView.readMoving();
                totalMove.add(selectedMove);
                outputView.printMap(totalMove, bridge);
                //outputView.printMap(totalMove, curLocation+1, bridge);
                boolean moveResult = bridgeGame.move(bridge, selectedMove, curLocation);
                if (!moveResult) {
                    break;
                }
                if (moveResult && curLocation == (bridgeSize - 1)) {
                    gameResult = successMessage;
                }
            }
            if(totalMove.size()>saveTotalMove.size()){
                saveTotalMove = totalMove;
            }
            if (!gameResult.equals(successMessage)) {
                outputView.printMessage(reGameOrNotMessage);
                String reGame = inputView.readGameCommand();
                retryResult = bridgeGame.retry(reGame);
            }
        }
        outputView.printResult(saveTotalMove, bridge, gameResult, cntTries);
    }
}

