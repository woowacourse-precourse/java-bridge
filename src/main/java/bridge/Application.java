package bridge;

import bridge.view.InputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGamePlayer bridgeGamePlayer = new BridgeGamePlayer();

        try{
            bridgeGamePlayer.run();
        }catch(IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }

    }
}
