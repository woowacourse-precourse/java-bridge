package bridge;

import bridge.constant.SuccessFail;

import java.util.List;

import static bridge.constant.SuccessFail.FAIL;
import static bridge.constant.SuccessFail.SUCCESS;

public class Judge {
    private final List<String> bridge;
    private final List<String> player;

    public Judge(List<String> bridge, List<String> player) {
        this.bridge = bridge;
        this.player = player;
    }

    public SuccessFail isSuccess() {
        if (bridge.equals(player))
            return SUCCESS;
        return FAIL;
    }

    public boolean isFinish() {
        if (isAlive() && (player.size() < bridge.size()))
            return false;

        if (!isAlive() || player.size() == bridge.size())
            return true;

        return false;
    }

    private boolean isAlive() {
        int nowIdx = player.size() - 1;
        String nowBridge = bridge.get(nowIdx);
        String nowPlayer = player.get(nowIdx);
        return nowPlayer.equals(nowBridge);
    }
}
