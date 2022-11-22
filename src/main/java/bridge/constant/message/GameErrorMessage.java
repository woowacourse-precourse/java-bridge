package bridge.constant.message;

import static bridge.constant.Config.*;

public enum GameErrorMessage implements ErrorMessage {
    NO_SUCH_DIRECTION("칸의 방향이 올바르지 않습니다."),
    NO_RANGE_OF_BRIDGE_SIZE("다리 길이는 " + RANGE_OF_BRIDGE_SIZE_START + "부터 " + RANGE_OF_BRIDGE_SIZE_END + "이여야 합니다."),
    NO_SUCH_COMMAND("존재하지 않은 명령어입니다."),
    NO_SUCH_ROAD_POSITION("아직 이동하지 않은 칸 위치입니다.");

    private String message;

    GameErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
