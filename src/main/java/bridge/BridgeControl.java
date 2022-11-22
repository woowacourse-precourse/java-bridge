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

    }

    public void start() {
        //게임 시작 메시지 출력
        outputView.printGameStart();

        //다리 길이 입력받기 및 다리생성
        try {
            getBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            getBridgeSize();
        }

        //게임 시작
        do{
            bridgeGame.retry();
            play();
        }while (isRetry());

        //결과 출력
        outputView.printResult(bridgeGame);
    }

    private void getBridgeSize(){
        try {
            int size = inputView.readBridgeSize();
            bridgeGame = new BridgeGame(size);
            //다리생성
            bridgeGame.setBridge(size);
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());

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
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getDashBoard(), bridgeGame.getCount());
            //x가 있거나 게임이 종료되면 false
            bridgeGame.checkWin();
            //System.out.println(bridgeGame.getDashBoard().get(0).get(0));
        }while(bridgeGame.isProceed());

    }
    private boolean isRetry(){
        //이겼으면 종료
        if(bridgeGame.getIsWin()){
            return false;
        }
        try {
            return inputView.readGameCommand();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            isRetry();
        }
        return true;
    }
}
