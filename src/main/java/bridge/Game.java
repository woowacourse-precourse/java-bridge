package bridge;

public class Game {
    public void start(){
        InputView inputView=new InputView();
        OutputView outputView=new OutputView();

        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize=inputView.readBridgeSize();

        BridgeGame bridgeGame=new BridgeGame(bridgeSize);
        while(true){
            String moving=inputView.readMoving();
            bridgeGame.move(moving);

        }
    }
}
