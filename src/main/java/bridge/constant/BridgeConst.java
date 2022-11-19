package bridge.constant;

public enum BridgeConst {
    MIN_LENGTH(3)
    , MAX_LENGTH(20)
    , UP("U")
    , DOWN("D")
    , RESTART("R")
    , QUIT("Q")
    , SUCCESS("성공")
    , FAILURE("실패")
    , POSSIBLE("O")
    , IMPOSSIBLE("X")
    ,
    ;

    private Integer number;

    private String letter;

    BridgeConst(int number) {
        this.number = number;
    }

    BridgeConst(String letter) {
        this.letter = letter;
    }

    public Integer getNumber() {
        return number;
    }

    public String getLetter() {
        return letter;
    }
}
