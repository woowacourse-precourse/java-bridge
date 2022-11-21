package bridge;

import bridge.model.GuessStartModel;
import bridge.model.OneGuessPhaseReturn;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.OutputView.*;

public class Run {
    public Run(){
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();

        int bridgeSize = startGame(inputView, outputView);
        List <String> bridge = createBridge(bridgeSize);
        guessStart(inputView, outputView, bridgeGame, bridge, bridgeSize);

    }
    private int startGame(InputView inputView, OutputView outputView){
        outputView.printMessage(gameStartMessage);
        outputView.printMessage(inputBridgeLengthMessage);
        int bridgeSize = inputView.readBridgeSize();
        return bridgeSize;
    }

    private List<String> createBridge(int bridgeSize){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    private void guessStart(InputView inputView, OutputView outputView, BridgeGame bridgeGame, List <String> bridge, int bridgeSize){
        GuessStartModel guessStartModel = new GuessStartModel();
        while(!((!guessStartModel.getRetryResult() && guessStartModel.getGameResult().equals(failMessage)) || guessStartModel.getGameResult().equals(successMessage))) {
            guessStartModel.setCntTries(guessStartModel.getCntTries()+1);
            OneGuessPhaseReturn oneGuessPhaseReturn = oneGuessPhase(inputView,outputView,bridgeGame,bridge,bridgeSize);
            guessStartModel.setGameResult(oneGuessPhaseReturn.getGameResult());
            guessStartModel.setSaveTotalMove(getSaveTotalMove(oneGuessPhaseReturn.getTotalMove(), guessStartModel.getSaveTotalMove()));
            guessStartModel.setRetryResult(ifGameResultSuccess(inputView, outputView, bridgeGame, guessStartModel.getGameResult(), guessStartModel.getRetryResult()));
        }
        outputView.printResult(guessStartModel.getSaveTotalMove(), bridge, guessStartModel.getGameResult(), guessStartModel.getCntTries());
    }

    private OneGuessPhaseReturn oneGuessPhase(InputView inputView, OutputView outputView, BridgeGame bridgeGame, List <String> bridge, int bridgeSize){
        OneGuessPhaseReturn oneGuessPhaseReturn = new OneGuessPhaseReturn();
        for (int curLocation = 0; curLocation < bridgeSize; curLocation++) {
            outputView.printMessage(selectUpDownMessage);
            String selectedMove = inputView.readMoving();
            oneGuessPhaseReturn.getTotalMove().add(selectedMove);
            outputView.printMap(oneGuessPhaseReturn.getTotalMove(), bridge);
            if (!bridgeGame.move(bridge, selectedMove, curLocation)) break;
            if (bridgeGame.move(bridge, selectedMove, curLocation) && curLocation == (bridgeSize - 1)) oneGuessPhaseReturn.setGameResult(successMessage);
        }
        return oneGuessPhaseReturn;
    }

    private List <String> getSaveTotalMove(List <String> totalMove, List <String> saveTotalMove){
        if(totalMove.size()>=saveTotalMove.size()){
            return totalMove;
        }
        return saveTotalMove;
    }
    private boolean ifGameResultSuccess(InputView inputView, OutputView outputView, BridgeGame bridgeGame, String gameResult, boolean retryResult){
        if (!gameResult.equals(successMessage)) {
            outputView.printMessage(reGameOrNotMessage);
            String reGame = inputView.readGameCommand();
            return bridgeGame.retry(reGame);
        }
        return retryResult;
    }
}

