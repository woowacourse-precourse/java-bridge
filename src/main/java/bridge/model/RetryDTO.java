package bridge.model;

import bridge.util.ViewClear;

public class RetryDTO {
    public ViewClear viewClear;
    public int TRY_COUNT;
    public String RESULT_CONDITION;
    public String GAME_RESULT;

    public RetryDTO(ViewClear viewClear, int TRY_COUNT, String RESULT_CONDITION, String GAME_RESULT) {
        this.viewClear = viewClear;
        this.TRY_COUNT = TRY_COUNT;
        this.RESULT_CONDITION = RESULT_CONDITION;
        this.GAME_RESULT = GAME_RESULT;
    }
}
