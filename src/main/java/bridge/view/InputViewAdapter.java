package bridge.view;

public class InputViewAdapter extends InputView {
    public int readBridgeSize() {
        do {
            try {
                return super.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String readMoving() {
        do {
            try {
                return super.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public String readGameCommand() {
        do {
            try {
                return super.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
}
