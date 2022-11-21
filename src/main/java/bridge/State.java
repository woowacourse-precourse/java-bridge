package bridge;

import static bridge.domain.BridgeConstants.QUIT;
import static bridge.domain.BridgeConstants.RETRY;

import java.util.Arrays;

public enum State {
    PLAYING(RETRY),
    QUIT_PLAYING(QUIT);

    private String cmd;

    State(String cmd) {
        this.cmd = cmd;
    }

    // 들어오는 커맨드(RETRY/QUIT)에 맞는 state return
    public State transitionTo(String cmd){
        return Arrays.stream(State.values())
                .filter(state -> state.stateEquals(cmd))
                .findAny()
                .orElse(PLAYING);
    }

    private boolean stateEquals(String cmd){
        return this.cmd.equals(cmd);
    }

}
