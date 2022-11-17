package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new InputView();
        int input = inputView.readBridgeSize();
                System.out.println(input);

//        String string = inputView.readMoving();


    }
}
