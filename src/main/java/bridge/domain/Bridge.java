package bridge.domain;

import java.util.List;

public class Bridge {

    private static final String EXCEPTION_MESSAGE_OVER_SIZE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final int BRIDGE_LOWER_NUMBER = 3;
    private static final int BRIDGE_UPPER_NUMBER = 20;
    private List<String> bridge;

    public Bridge() {
        this.bridge = null;
    }

    public void setBridge(List<String> bridge) {
        validate(bridge);
        this.bridge = bridge;
    }

    private void validate(List<String> bridge) {
        int size = bridge.size();
        if ((size < BRIDGE_LOWER_NUMBER) || (size > BRIDGE_UPPER_NUMBER)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVER_SIZE);
        }
    }

    public String getNowCompartment(int now){
        return bridge.get(now);
    }

    public int getBridgeLength(){
        return bridge.size();
    }
}
