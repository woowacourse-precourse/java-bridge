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
            for(String str : bridge){
                System.out.printf(str + " ");
            }

            outputView.printRequestUpDownMessage();
            String move = inputView.readMoving();
            String oneBridge = bridgeGame.move(bridge, move, bridgeGame.getSize());
            outputView.printMap(oneBridge);
            bridgeGame.nextStep();

            if(isWrong(oneBridge)){
                outputView.printRequestRetry();
                inputView.readGameCommand();
                bridgeGame.clearResultRestart();
                bridgeGame.initLevel();
            }
        }
    }

    public void isFinish(String str){
        if(str.equals("R")){

        }
        if(str.equals("Q")){

        }
    }

    public boolean isWrong(String bridge){
        if(bridge.contains("X")){
            return true;
        }
        return false;
    }

}
