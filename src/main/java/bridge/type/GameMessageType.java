package bridge.type;

public enum GameMessageType {
    INIT_MESSAGE("다리 건너기 게임을 시작합니다."),
    ASK_BRINDGE_SIZE_MESSAGE("다리의 길이를 입력해주세요."),
    ASK_IN_GAME_COMMAND_MESSAGE("이동할 칸을 선택해주세요. (%s)",
            InGameCommandType.getDescription()),
    ASK_FAIL_MENU_COMMAND_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (%s)",
            FailMenuCommandType.getDescription()),
    ;

    private final String message;

    GameMessageType(String message, Object... replacers) {
        this.message = String.format(message, replacers);
    }

    @Override
    public String toString() {
        return message;
    }
}
