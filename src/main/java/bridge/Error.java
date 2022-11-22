package bridge;

public class Error {
    public void errorBridgeSize(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalAccessError("[ERROR] 다리의 길이가 3~20 사이에 포함되지 않습니다.");
        }
    }
}
