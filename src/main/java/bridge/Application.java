package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView ip = new InputView();
        int i = ip.readBridgeSize();
        System.out.println(i);
    }
}
