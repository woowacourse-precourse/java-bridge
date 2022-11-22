package bridge;

public class BridgeGameView {

    private final InputView inputView = new InputView();

    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");

        try {
            return inputView.readBridgeSize();
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        }
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동할 칸은 U 또는 D로 이동할 수 있습니다.");
            return readMoving();
        }
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 재시도 여부는 R 또는 Q로 입력해주세요.");
            return readGameCommand();
        }
    }

}
