package bridge.ui.output;

public enum Components {

    CORRECT_CHOICE("O"),
    NON_CHOICED(" "),
    WRONG_CHOICE("X"),
    FRONT_WRAPPER("[ "),
    LAST_WRAPPER(" ]"),
    SEPERATOR(" | "),
    GAME_NOTIFICATION("최종 게임 결과"),
    SUCCESS_NOTIFICATION("게임 성공 여부: "),
    COUNT_NOTIFICATION("총 시도한 횟수: "),
    SUCCESS("성공"),
    FAIL("실패");

    private final String component;

    Components(String component) {
        this.component = component;
    }

    public String getValue() {
        return component;
    }
}
