package bridge;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        while(true){
            input.readBridgeSize();

            if(input.readGameCommand())
                break;
        }
    }
}
