package bridge.view;

/**
 * 입력값 에러 발생시 다시 입력값을 받도록 해주는 클래스
 */
public class InputViewProxy extends InputView {

    @Override
    public int readBridgeSize() {
        try {
            return super.readBridgeSize();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readBridgeSize();
        }
    }

    @Override
    public String readMoving() {
        try {
            return super.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readMoving();
        }
    }

    @Override
    public String readGameCommand() {
        try {
            return super.readGameCommand();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            return this.readGameCommand();
        }
    }
}
