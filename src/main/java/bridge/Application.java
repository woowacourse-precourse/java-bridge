package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            OutputView outputView = new OutputView();
            outputView.printStartMessage();

            InputView inputView = new InputView();
            inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
