package bridge.utils.message;

import bridge.utils.common.BridgeConst;
import bridge.utils.common.CommandConst;

public enum ExceptionMessageUtils {
    WRONG_BRIDGE_SIZE("다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
            BridgeConst.MIN_BRIDGE_SIZE,
            BridgeConst.MAX_BRIDGE_SIZE),

    WRONG_PLAYER_MOVE("이동할 칸은 %s(위 칸) 혹은 %s(아래 칸)만을 선택할 수 있습니다.",
            CommandConst.PLAYER_MOVE_UP,
            CommandConst.PLAYER_MOVE_DOWN),

    WRONG_GAME_COMMAND("게임 시도 여부는 %s(재시도) 혹은 %s(종료)만을 선택할 수 있습니다.",
            CommandConst.GAME_RETRY,
            CommandConst.GAME_QUIT);

    private final String message;

    ExceptionMessageUtils(String baseMessage, Object... replaces) {
        this.message = String.format(baseMessage, replaces);
    }

    public String getMessage() {
        return message;
    }
}
