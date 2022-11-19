package bridge;

public class Game {
    private InputView inputView = new InputView();
    private OutputView outputView ;
    public void start(){
        BridgeGame bridgeGame = new BridgeGame();
        outputView = new OutputView(bridgeGame);
        System.out.println("다리 건너기 게임을 시작합니다.");
        int sizeInput = inputView.readBridgeSize();
        bridgeGame.init(sizeInput);
        while(bridgeGame.getSuccess()){
            int i;
            for(i = 0 ; i < sizeInput ; i++){
                if(!bridgeGame.getSuccess()){
                    break;
                }
                String moveInput = inputView.readMoving();
                outputView.printMap(moveInput);
            }
            if(!bridgeGame.getSuccess()){
                String retryInput = inputView.readGameCommand();
                bridgeGame.retry(retryInput);
            }
            if(!bridgeGame.getSuccess()){
                outputView.printResult();
                outputView.printgetInfo();
            }
            if(bridgeGame.getSuccess() && i==sizeInput){
                outputView.printResult();
                outputView.printgetInfo();
                break;
            }
        }
    }
}
