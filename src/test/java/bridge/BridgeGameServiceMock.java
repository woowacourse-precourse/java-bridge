package bridge;

import bridge.constant.State;
import bridge.service.BridgeGameService;
import java.util.Arrays;

public class BridgeGameServiceMock extends BridgeGameService {

    @Override
    public void makeBridge(int size) {
        return;
    }

    @Override
    public Result move(String direction) {
        return new Result(Arrays.asList("U", "U", "U"), new UserInfo(Arrays.asList("D"), 1, State.Loss));
    }

    @Override
    public void retry() {
        return;
    }

    @Override
    public Result getResult() {
        return new Result(Arrays.asList("U", "U", "U"), new UserInfo(Arrays.asList("D"), 1, State.Loss));
    }
}
