package bridge;

public enum GameResult {
    PASSED("성공",true),
    FAILED("실패",false);


    private String isPass;
    private boolean trueOrFalse;
    private GameResult(String isPass, boolean trueOrFalse){
        this.isPass = isPass;
        this.trueOrFalse = trueOrFalse;
    }
    public String getIsPass(){
        return this.isPass;
    }
    public boolean getTrueOrFalse(){
        return this.trueOrFalse;
    }
}
