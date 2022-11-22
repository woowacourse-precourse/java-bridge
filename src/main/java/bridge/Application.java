package bridge;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameCount = 0;
        boolean retry = true;

        InputView Input = new InputView();
        int bridgeSize =Input.readBridgeSize();

        BridgeMaker Bridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge.makeBridge(bridgeSize);
        System.out.println(Bridge.getBridge());

        while (retry){
            BridgeGame Game =  new BridgeGame(bridgeSize,Bridge.getBridge());
            retry=Game.move(Input);
        }

//        Input.readGameCommand();


    }
}
