package bridge;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            inputView.readBridgeSize();
        }catch(IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
        }
    }
}
