package bridge.service;

import bridge.constant.GameInInformation;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private int attemp;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeService(OutputView outputView, BridgeGame bridgeGame){
        attemp = 1;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
    }

    public void start(){
        gameLoop();
    }

    private void gameLoop(){
        while(true){
            if(gameStart()){
                outputView.printSuccessResult(attemp);
                return;
            }
            if (isGameOver()) break;
            attemp++;
        }
    }

    private boolean isGameOver() {
        String nextGameMode = bridgeGame.getBridgeInit().getNextGameMode();
        if(nextGameMode.equals(GameInInformation.QUIT)){
            stopGame();
            return true;
        }
        return false;
    }

    private boolean possibleNextStep(int index, String nextStep) {
        if(!bridgeGame.move(index, nextStep)) {
            printFail(nextStep);
            return true;
        }
        return false;
    }

    private void stopGame() {
        outputView.printInformation(bridgeGame.getBridgePainting().getLine1(), bridgeGame.getBridgePainting().getLine2());
        outputView.printFailureResult(attemp);
    }

    private boolean gameStart() {
        int index = readyForGame();
        while (true) {
            if (index == bridgeGame.getBridge().size()) return true;
            String nextStep = bridgeGame.getBridgeInit().getNextStep();
            if (possibleNextStep(index, nextStep)) {
                outputView.printResult(bridgeGame.getBridgePainting().getLine1(), bridgeGame.getBridgePainting().getLine2());
                return false;
            }
            index = gameProgress(index, nextStep);
        }
    }

    private int readyForGame() {
        int index = 0;
        List<String> bridge = bridgeGame.getBridge();
        bridgeGame.retry();
        return index;
    }

    private int gameProgress(int index, String nextStep) {
        nextStepSuccess(nextStep);
        index++;
        pushSideSign(index);
        outputView.printMap(bridgeGame.getBridgePainting().getLine1(), bridgeGame.getBridgePainting().getLine2());
        return index;
    }

    private void pushSideSign(int index){
        if(index == bridgeGame.getBridge().size()){
            bridgeGame.getBridgePainting().pushCloseBRACKET();
            return;
        }
        bridgeGame.getBridgePainting().pushBoundary();
    }

    private void printFail(String step){
        bridgeGame.getBridgePainting().inCorrectStep(step);
    }

    private void nextStepSuccess(String step){
        bridgeGame.getBridgePainting().correctStep(step);
    }
}
