package bridge.service;

import bridge.controller.GameFlag;
import bridge.domain.Bridge;
import bridge.domain.BridgeFlag;
import bridge.domain.Map;
import bridge.domain.UpDownFlag;
import bridge.domain.User;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeService {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeService(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public Bridge makeBridge() {
        outputView.printEnterBridgeLength();
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);
        return Bridge.of(bridge);
    }

    public BridgeFlag getGameStatus(Bridge bridge, User user) {
        if (bridge.getLength() < user.getMovedLength()) {
            throw new IllegalArgumentException("[ERROR] 유저가 건넌 다리의 길이가 다리의 길이보다 깁니다.");
        }
        return isCrossOver(bridge.getBridge(), user.getMovedPosition());
    }

    private BridgeFlag isCrossOver(List<UpDownFlag> bridge, List<UpDownFlag> user) {
        for (int i = 0; i < user.size(); i++) {
            if (bridge.get(i) != user.get(i)) {
                return BridgeFlag.FAIL;
            }
        }
        if (bridge.size() == user.size()) {
            return BridgeFlag.SUCCESS;
        }
        return BridgeFlag.NOTHING;
    }

    public void printStartMessage() {
        outputView.printGameStartMessage();
    }

    public UpDownFlag receiveMoving() {
        outputView.printEnterSelectMoving();
        String input = inputView.readMoving();
        return UpDownFlag.ofString(input);
    }

    public void printMap(Map map) {
        outputView.printMap(map);
    }

    public GameFlag receiveRestart() {
        outputView.printRestartOrQuitMessage();
        String input = inputView.readGameCommand();
        return GameFlag.ofString(input);
    }

    public void printResult(Map map, BridgeFlag result, int tryCount) {
        outputView.printResult(map, result, tryCount);
    }
}
