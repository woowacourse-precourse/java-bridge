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


    /**
     * 움직이는 입력값 받고 출력하는 함수
     */
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


    /**
     *  재시작을 할 것인지 안할 것인지 정하는 ㅎ마수
     */
    private void selectRetry(){
        if(!bridgeGame.getSuccess()){
            String retryInput = inputView.readGameCommand();
            bridgeGame.retry(retryInput);
        }
    }

    /**
     * 멈추는 것을 선택하면 최종결과 출력하는 메서드
     */
    private void stopOrRestartGame(){
        if(!bridgeGame.getSuccess()){
            outputView.printResult();
            outputView.printgetInfo();
        }
    }
}
