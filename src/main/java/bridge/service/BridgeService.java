package bridge.service;

public class BridgeService {
    private final InputService inputService = new InputService();

    public void gameStart() {
        inputService.printGameStart();
    }

    public int getBridgeSize() {
        return inputService.requestBridgeSize();
    }
}
