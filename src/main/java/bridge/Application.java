package bridge;

public class Application {
    private InputView input;
    private OutputView output;
    Application(){
        this.input = new InputView();
        this.output = new OutputView();
    }

    public static void main(String[] args) {
        BridgeGame game = new BridgeGame();
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // TODO: 프로그램 구현
    }
}
