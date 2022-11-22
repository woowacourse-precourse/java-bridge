package bridge;

import static bridge.BridgeLength.BLANK_CRITERIA;
import static bridge.BridgeLength.EMPTY_CRITERIA;

public class BridgeGameRestart {

    private static final String RESTART = "R";
    private static final String END = "Q";

    private final String gameRestart;

    public BridgeGameRestart(String gameRestart) {
        this.gameRestart = validate(gameRestart);
    }

    public boolean isRestart() {
        return this.gameRestart.equals(RESTART);
    }

    private String validate(String gameRestart) {
        validateEmpty(gameRestart);
        validateBlank(gameRestart);
        validateGameRestart(gameRestart);
        return gameRestart;
    }

    private void validateEmpty(String gameRestart) {
        if (gameRestart.length() == EMPTY_CRITERIA) {
            throw new IllegalArgumentException("[ERROR] 입력을 하지 않았습니다.");
        }
    }

    private void validateBlank(String gameRestart) {
        if (gameRestart.contains(BLANK_CRITERIA)) {
            throw new IllegalArgumentException("[ERROR] 입력 값의 공백이 포함 되어있습니다.");
        }
    }

    private void validateGameRestart(String gameRestart) {
        if (!(gameRestart.equals(RESTART) || gameRestart.equals(END))) {
            throw new IllegalArgumentException("[ERROR] 게임을 다시 시도할지 여부는 R 또는 Q를 입력해주세요.");
        }
    }

}
