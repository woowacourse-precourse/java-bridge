package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int number = InputView.readBridgeSize();
        System.out.println("This is " + number);

        String input1 = InputView.readMoving();
        System.out.println("input1 : " + input1);
        String input2 = InputView.readGameCommand();
        System.out.println("input2 : " + input2);
    }
}
