package bridge;

public class BridgeGameView {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public int readBridgeSize() {
        outputView.pringMessage("다리의 길이를 입력해주세요.");

        try {
            return inputView.readBridgeSize();
        } catch (NumberFormatException e) {
            outputView.pringMessage("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        } catch (IllegalArgumentException e) {
            outputView.pringMessage("[ERROR] 3부터 20사이의 정수를 입력해주세요.");
            return readBridgeSize();
        }
    }

    public String readMoving() {
        outputView.pringMessage("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            outputView.pringMessage("[ERROR] 이동할 칸은 U 또는 D로 이동할 수 있습니다.");
            return readMoving();
        }
    }

    public String readGameCommand() {
        outputView.pringMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            outputView.pringMessage("[ERROR] 재시도 여부는 R 또는 Q로 입력해주세요.");
            return readGameCommand();
        }
    }

}
