package bridge.controller.request;

public class BridgeSizeRequest {

    private final static String REG_EXP = "^[0-9]+$";
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;

    private final int size;

    public BridgeSizeRequest(String size) {
        validate(size);
        this.size = Integer.parseInt(size);
    }

    private void validate(String size) {
        if (!size.matches(REG_EXP)) {
            throw new IllegalArgumentException("길이는 숫자타입이어야 합니다.");
        }
        if (Integer.parseInt(size) < MIN_SIZE) {
            throw new IllegalArgumentException("길이는 3 이상이어야 합니다.");
        }
        if (Integer.parseInt(size) > MAX_SIZE) {
            throw new IllegalArgumentException("길이는 20 이하이어야 합니다.");
        }
    }

    public int getSize() {
        return size;
    }
}
