package bridge.view;

import bridge.Constants;

public enum InputMessage {
    BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    MOVING(String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
            Constants.CODE_UP, Constants.CODE_DOWN)),
    GAME_COMMAND(String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
            Constants.CODE_RETRY, Constants.CODE_QUIT));
    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
