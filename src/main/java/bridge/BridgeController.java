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

            if(!isFinish(oneBridge)){
                String result = bridgeGame.printFinalBridge(bridge);
                outputView.printEndGame();
                System.out.println(result);
                break;
            }
            bridgeGame.nextStep();
        }
    }

    public boolean isFinish(String input){
        if(input.contains("X")){
            outputView.printRequestRetry();
            String strRetry = inputView.readGameCommand();
            if(strRetry.equals("R")){
//                gameRestart;
            }
            if(strRetry.equals("Q")){
                return false;
            }
        }
        return true;
    }
}
