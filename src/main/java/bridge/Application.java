package bridge;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        int gameCount = 0 ;
        String retry = "CONTINUE";
        InputView Input = new InputView();
        OutputView Output = new OutputView();
        int bridgeSize =Input.readBridgeSize();

        BridgeMaker Bridge = new BridgeMaker(new BridgeRandomNumberGenerator());
        Bridge.changeNumberToString(bridgeSize);

        while (retry.equals("CONTINUE")){
            gameCount++;
            retry=new BridgeGame(bridgeSize,Bridge.getBridge()).move(Input,Output);
        }
        Output.printResult(gameCount,retry);
    }
}
