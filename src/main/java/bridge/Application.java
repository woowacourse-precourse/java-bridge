package bridge;

public class Application {
    private InputView input;
    private OutputView output;
    Application(){
        this.input = new InputView();
        this.output = new OutputView();
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.output.printGameStart();
        app.output.printInputRequestMessage();
        // TODO: 프로그램 구현
    }
}
