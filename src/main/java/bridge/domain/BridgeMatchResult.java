package bridge.domain;

import bridge.utils.Constants;

public enum BridgeMatchResult {
    UP_RIGHT(Constants.CORRECT_MARK, Constants.BLANK_MARK),
    UP_WRONG(Constants.INCORRECT_MARK, Constants.BLANK_MARK),
    DOWN_RIGHT(Constants.BLANK_MARK, Constants.CORRECT_MARK),
    DOWN_WRONG(Constants.BLANK_MARK, Constants.INCORRECT_MARK)
    ;

    private final String upMark;
    private final String downMark;

    BridgeMatchResult(String upMark, String downMark) {
        this.upMark = upMark;
        this.downMark = downMark;
    }

    public String getUpMark() {
        return this.upMark;
    }

    public String getDownMark() {
        return this.downMark;
    }
}
