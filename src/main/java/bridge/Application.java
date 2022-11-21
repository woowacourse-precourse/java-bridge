package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
//        BridgeMaker bridgeMaker = new BridgeMaker();
        try{
            bridgeGame.move(inputView.readBridgeSize());    // 게임 시작
        } catch (IllegalArgumentException e){
        }



    }
}
