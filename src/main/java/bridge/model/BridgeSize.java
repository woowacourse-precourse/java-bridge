package bridge.model;

public class BridgeSize {
    private final int bridgeSize;

    public BridgeSize(String bridgeSize) {

        validateNotNull(bridgeSize);
        validateNumber(bridgeSize);
        validateRange(Integer.parseInt(bridgeSize));

        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    private void validateNotNull(String bridgeSize) {
        if (bridgeSize == null || "".equals(bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateNumber(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void validateRange(int bridgeSize) {
        if(bridgeSize<3 || bridgeSize>20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
