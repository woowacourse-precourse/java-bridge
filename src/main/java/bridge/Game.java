package bridge;

import java.util.List;

public class Game {
    private final InputView inputView=new InputView();
    private final OutputView outputView=new OutputView();
    private List<String> answerBridge;
    private List<String> userBridge;

    public void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize=inputView.readBridgeSize();

        BridgeGame bridgeGame=new BridgeGame(bridgeSize);
        answerBridge=bridgeGame.getAnswerBridge();
        doGame(bridgeGame);

        outputView.printResult(userBridge,answerBridge,bridgeGame.getGameCount());
    }

    public void doGame(BridgeGame bridgeGame){
        while(true){
            doMoving(bridgeGame);
            if(outputView.checkSuccess(userBridge,answerBridge)){
                break;
            }
            int nowIndex=userBridge.size()-1;
            if(!checkRetry(bridgeGame, nowIndex)){
                break;
            }
        }
    }

    public void doMoving(BridgeGame bridgeGame){
        String moving=inputView.readMoving();
        bridgeGame.move(moving);
        userBridge=bridgeGame.getUserBridge();
        outputView.printMap(userBridge,answerBridge);
    }

    public boolean checkRetry(BridgeGame bridgeGame, int nowIndex){
        if(!outputView.checkSameMove(userBridge,answerBridge,nowIndex)){
            String gameCommand=inputView.readGameCommand();
            if(gameCommand=="Q"){
                return false;
            }
            bridgeGame.retry();
            bridgeGame.setGameCount();
        }
        return true;
    }
}
