package bridge.view;

import static bridge.util.CharacterUnit.ENTER;

public enum InputViewMessage {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다." + ENTER.getUnit()),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요." + ENTER.getUnit()),
    READ_MOVE_BOARD("이동할 칸을 선택해주세요. (위: U, 아래: D)" + ENTER.getUnit());

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
