package bridge;

public enum BridgeGameMark {
    UP_MARK("U"),
    DOWN_MARK("D"),
    BLANK_MARK(" "),
    ANSWER_MARK("O"),
    WRONG_ANSWER_MARK("X"),
    QUIT_MARK("Q"),
    RETRY_MARK("R"),
    UP_INPUT_MARK("1"),
    DOWN_INPUT_MARK("0");

    private final String mark;

    BridgeGameMark(String mark){
        this.mark = mark;
    }

    public String getMark(){
        return mark;
    }
}


