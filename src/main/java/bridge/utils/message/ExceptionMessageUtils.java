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
            CommandConst.GAME_QUIT),

    WRONG_GENERATOR("다리를 생성하는 generator는 %d(위 칸) 또는 %d(아래 칸)만을 생성할 수 있습니다.",
            BridgeConst.UP_TILE_VALUE,
            BridgeConst.DOWN_TILE_VALUE),

    NOT_FOUND_VIEW("지정한 타입에 맞는 View를 찾을 수 없습니다"),

    WRONG_CONFIGURATION("잘못된 애플리케이션 구성으로 인한 문제가 발생했습니다.");

    private final String message;

    ExceptionMessageUtils(String baseMessage, Object... replaces) {
        this.message = String.format(baseMessage, replaces);
    }

    public String getMessage() {
        return message;
    }
}
