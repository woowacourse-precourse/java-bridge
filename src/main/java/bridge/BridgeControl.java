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
        getBridgeSize();

        //게임 시작
        play();
        //결과 출력
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
        String
        do {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.);
        }while(retry());
    }
    private boolean retry(){
        if(bridgeGame.getIsWin()){
            return false;
        }
        return true;
    }
}
