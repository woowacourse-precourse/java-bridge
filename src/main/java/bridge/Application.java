package bridge;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int gameCount = 0 ;
        String retry = "CONTINUE";

        InputView Input = new InputView();
        OutputView Output = new OutputView();
        int bridgeSize =Input.readBridgeSize();

        BridgeMaker Bridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge.changeNumberToString(bridgeSize);
//        System.out.println(Bridge.getBridge());

        while (retry.equals("CONTINUE")){
            gameCount++;
            BridgeGame Game =  new BridgeGame(bridgeSize,Bridge.getBridge());
            retry=Game.move(Input,Output);
        }
        if (retry.equals("STOP")){Output.printResult(gameCount,false);}
        if (retry.equals("COMPLETE")){Output.printResult(gameCount,true);}
    }
}
