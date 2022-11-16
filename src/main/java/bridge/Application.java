package bridge;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        InputView inputView = new InputView();
        String readValue = inputView.readBridgeSize();
        int size = checkSize(readValue);
    }

    public static int checkSize(String str) {
        int size = 0;
        try {
            size = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            //throw new IllegalArgumentException("[ERROR] 다시 시도해 주세요.");
            InputView inputView = new InputView();
            String s = inputView.readBridgeSize();
            checkSize(s);
        }
        return size;
    }
}
