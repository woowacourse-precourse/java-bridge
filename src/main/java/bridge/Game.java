package bridge;

public class Game {
    private InputView inputView = new InputView();
    private OutputView outputView ;
    private BridgeGame bridgeGame = new BridgeGame();
    public void start(){
        outputView = new OutputView(bridgeGame);
        System.out.println("다리 건너기 게임을 시작합니다.");
        int sizeInput = inputView.readBridgeSize();
        bridgeGame.init(sizeInput);
        while(bridgeGame.getSuccess()){
            int i = 0;
            i = readMoving(i,sizeInput);
            selectRetry();
            stopOrRestartGame();
            if(bridgeGame.getSuccess() && i==sizeInput){
                outputView.printResult();
                outputView.printgetInfo();
                break;
            }
        }
    }

    private int readMoving(int i ,int sizeInput){
        for(i = 0 ; i < sizeInput ; i++){
            if(!bridgeGame.getSuccess()){
                break;
            }
            String moveInput = inputView.readMoving();
            outputView.printMap(moveInput);
        }
        return i;
    }

    private void selectRetry(){
        if(!bridgeGame.getSuccess()){
            String retryInput = inputView.readGameCommand();
            bridgeGame.retry(retryInput);
        }
    }

    private void stopOrRestartGame(){
        if(!bridgeGame.getSuccess()){
            outputView.printResult();
            outputView.printgetInfo();
        }
    }
}
