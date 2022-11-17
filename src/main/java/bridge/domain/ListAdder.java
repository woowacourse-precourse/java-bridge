package bridge.domain;

import java.util.List;

public interface ListAdder {
    String EMPTY_MESSAGE = "   ";
    void add(String mes);
}


class UpAdder implements ListAdder {
    List<String> upBridge;
    List<String> downBridge;

    UpAdder(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    @Override
    public void add(String message) {
        upBridge.add(message);
        downBridge.add(EMPTY_MESSAGE);
    }
}

class DownAdder implements ListAdder {
    List<String> upBridge;
    List<String> downBridge;

    DownAdder(List<String> upBridge, List<String> downBridge) {
        this.upBridge = upBridge;
        this.downBridge = downBridge;
    }

    @Override
    public void add(String message) {
        upBridge.add(EMPTY_MESSAGE);
        downBridge.add(message);
    }
}

