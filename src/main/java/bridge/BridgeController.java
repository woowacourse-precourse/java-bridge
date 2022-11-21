package bridge;

import java.util.List;

public class BridgeController {

    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startGame(){
        bridgeGame.gameStart();
    }

    public List<String> bridgeMake(){
        int bridgeSize = bridgeGame.requestBridgeSize();
        return bridgeGame.makeBridge(bridgeSize);
    }

    public void playBridgeGame(List<String> bridge){
        while(bridgeGame.getSize() < bridge.size()){
            outputView.printRequestUpDownMessage();
            String move = inputView.readMoving();
            String oneBridge = bridgeGame.move(bridge, move, bridgeGame.getSize());
            outputView.printMap(oneBridge);
            System.out.println("");
            bridgeGame.nextStep();

            if(isWrong(oneBridge)){
                outputView.printRequestRetry();
                String input = inputView.readGameCommand();
                if(!isFinish(bridge, input)){
                    break;
                }
                bridgeGame.clearResultRestart();
                bridgeGame.initLevel();
            }
        }

        outputView.printEndGame();
        String s = bridgeGame.printFinalBridge(bridge);
        System.out.println(s);
        outputView.printSuccess(bridge, bridgeGame.getSize());
        outputView.printTryCount(bridgeGame.getTryCount());
    }

    public boolean isFinish(List<String> bridge, String str){
        if(str.equals("Q")){
            return false;
        }
        return true;
    }

    public boolean isWrong(String bridge){
        if(bridge.contains("X")){
            return true;
        }
        return false;
    }

}
