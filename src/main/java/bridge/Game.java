package bridge;

import java.util.List;

public class Game {
    public void start(){
        InputView inputView=new InputView();
        OutputView outputView=new OutputView();

        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize=inputView.readBridgeSize();

        BridgeGame bridgeGame=new BridgeGame(bridgeSize);
        List<String> answerBridge=bridgeGame.getAnswerBridge();
        List<String> userBridge;
        while(true){
            String moving=inputView.readMoving();
            bridgeGame.move(moving);
            userBridge=bridgeGame.getUserBridge();
            outputView.printMap(userBridge,answerBridge);
            if(outputView.checkSuccess(userBridge,answerBridge)){
                break;
            }
            int nowIndex=userBridge.size();
            if(!outputView.checkSameMove(userBridge,answerBridge,nowIndex)){
                String gameCommand=inputView.readGameCommand();
                if(gameCommand=="Q"){
                    break;
                }
                bridgeGame.retry();
                bridgeGame.setGameCount();
            }
        }
        outputView.printResult(userBridge,answerBridge,bridgeGame.getGameCount());
    }
}
