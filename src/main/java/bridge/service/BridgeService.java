package bridge;

import bridge.BridgeGame;
import bridge.BridgeInit;

import java.util.List;

public class BridgeService {

    private int attemp;
    private final BridgeInit bridgeInit;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgePainting bridgePainting;
    private List<String> bridge;

    BridgeService(BridgeInit bridgeInit, BridgeGame bridgeGame, BridgePainting bridgePainting){
        attemp = 1;
        this.outputView = new OutputView();
        this.bridgeGame = bridgeGame;
        this.bridgeInit = bridgeInit;
        this.bridgePainting = bridgePainting;
    }

    public void gameInit(){
        bridge = bridgeInit.makeGame();
    }

    public void start(){
        gameLoop();
    }

    private void gameLoop(){
        while(true){
            boolean isSuccess = gameStart();
            if(isSuccess){
                outputView.printSuccessResult(attemp);
                return;
            }
            String nextGameMode = bridgeInit.getNextGameMode();
            if(nextGameMode.equals(Position.QUIT)){
                outputView.printInformation(bridgePainting.getLine1(), bridgePainting.getLine2());
                outputView.printFailureResult(attemp);
                break;
            }
            attemp++;
        }
    }

    private boolean gameStart() {
        int index = 0;
        bridgePainting.init();
        while (true) {
            if (index == bridge.size()) return true;
            String nextStep = bridgeInit.getNextStep();
            if (possibleNextStep(index, nextStep)) {
                outputView.printResult(bridgePainting.getLine1(), bridgePainting.getLine2());
                return false;
            }
            printSuccess(nextStep);
            index++;
            printBound(index);
            outputView.printMap(bridgePainting.getLine1(), bridgePainting.getLine2());
        }
    }

    private boolean possibleNextStep(int index, String nextStep) {
        if(!bridgeGame.move(bridge, index, nextStep)) {
            printFail(nextStep);
            return true;
        }
        return false;
    }

    private void printBound(int index){
        if(index == bridge.size()){
            bridgePainting.pushCloseBRACKET();
            return;
        }
        bridgePainting.pushBoundary();
    }

    private void printFail(String step){
        bridgePainting.inCorrectStep(step);
    }

    private void printSuccess(String step){
        bridgePainting.correctStep(step);
    }
}
