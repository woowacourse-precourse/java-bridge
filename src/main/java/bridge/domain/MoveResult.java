package bridge.domain;

public enum MoveResult {
    SUCCESS("O"),
    FAIL("X");

    final String symbol;


    MoveResult(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }

}
