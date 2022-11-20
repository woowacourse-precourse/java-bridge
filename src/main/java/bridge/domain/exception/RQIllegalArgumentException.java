package bridge.domain.exception;

import bridge.domain.resources.ReOrQuit;

public class RQIllegalArgumentException extends IllegalArgumentException {

    private static final String ONLY_R_OR_Q = String.format("[ERROR] %s과 %s만 입력이 가능합니다.", ReOrQuit.RE_GAME, ReOrQuit.QUIT_GAME);

    public RQIllegalArgumentException() {
        super(ONLY_R_OR_Q);
    }
}
