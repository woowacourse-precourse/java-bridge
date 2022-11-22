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
        //BridgeGame = new BridgeGame();
    }

    public void start() {
        //게임 시작 메시지 출력
        outputView.printGameStart();

        //다리 길이 입력받기
        getBridgeSize();

        //다리 생성

        //게임 시작
        
        //결과 출력
    }
    private void getBridgeSize(){
        try {
            int size = inputView.readBridgeSize();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
