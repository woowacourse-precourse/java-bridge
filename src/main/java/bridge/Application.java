package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeProgram bridgeProgram = new BridgeProgram(new BridgeGame(), new InputView(new Validation()), new OutputView());
        bridgeProgram.runBridgeProgram();
    }
}
