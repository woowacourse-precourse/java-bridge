package bridge;

public enum GameResult {
    PASS("O"),
    FAIL("X"),
    NOTCHOICE(" ");

    private final String result;

    GameResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }

    public boolean fail(){
        return this.equals(FAIL);
    }


}
