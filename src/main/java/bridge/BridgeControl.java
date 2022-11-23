package bridge;

import  bridge.BridgeGame;
import  bridge.InputView;
import  bridge.OutputView;
public class BridgeControl {

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;

    public BridgeControl() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void start() {
        //게임 시작 메시지 출력
        outputView.printGameStart();
        //다리 길이 입력받기 및 다리생성
        getBridgeSize();
        //게임 시작
        try{
            do{
                bridgeGame.retry();
                play();
            }while (isRetry());
        }
        catch (NullPointerException e){
            return;
        }
        //결과 출력
        outputView.printResult(bridgeGame);
    }

    private void getBridgeSize(){
        try {
            outputView.printBridgeSize();
            int size = inputView.readBridgeSize();
            //다리생성
            bridgeGame.setBridge(size);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
    }

    private void play(){
       try {
           moving();
       }catch (IllegalArgumentException e){
           System.out.println(e.getMessage());
           play();
       }
    }
    private void moving(){
        do {
            outputView.printMoving();
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getDashBoard(), bridgeGame.getCount());
            //x가 있거나 게임이 종료되면 false
            bridgeGame.checkWin();
        }while(bridgeGame.isProceed());

    }
    private boolean isRetry(){
        //이겼으면 종료
        if(bridgeGame.getIsWin()){
            return false;
        }
        try {
            outputView.printRetryGameCommand();
            return inputView.readGameCommand();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            isRetry();
        }
        return true;
    }
}
