package bridge.view;

import static bridge.config.CharacterConfiguration.ENTER;

public enum OutputViewMessage {

    FINAL_GAME_RESULT("최종 게임 결과" + ENTER.getConfig()),
    GAME_WIN_RESULT("게임 성공 여부: {0}" + ENTER.getConfig()),
    TOTAL_ROUND("총 시도한 횟수: {0}");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
