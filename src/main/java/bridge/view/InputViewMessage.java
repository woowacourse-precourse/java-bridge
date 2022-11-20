package bridge.view;

import static bridge.config.CharacterConfiguration.ENTER;

public enum InputViewMessage {
    START_BRIDGE_GAME("다리 건너기 게임을 시작합니다." + ENTER.getConfig()),
    READ_BRIDGE_SIZE("다리의 길이를 입력해주세요." + ENTER.getConfig()),
    READ_MOVE_BOARD("이동할 칸을 선택해주세요. (위: U, 아래: D)" + ENTER.getConfig()),
    READ_SELECT_GAME_END_TYPE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" + ENTER.getConfig());

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
