package bridge;

public class Application {
    static void startMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    static int readBridgeSize(InputView input) {
        System.out.println("다리의 길이를 입력해주세요.");
        int readInput = input.readBridgeSize();
        System.out.println();
        return readInput;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            startMessage();
            InputView input = new InputView();
            int bridgeSize = readBridgeSize(input);
        } catch (IllegalArgumentException exception) {
            System.out.print("[ERROR] ");
            System.out.println(exception.getMessage());
        }
    }
}
