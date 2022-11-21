package bridge;

public enum Bridge {
    FAILURE_UPPER("U", "X"),
    SUCCESS_UPPER("U", "O"),
    FAILURE_LOWER("D", "X"),
    SUCCESS_LOWER("D", "O");

    private final String direct;
    private final String result;

    Bridge(String direct, String result){
        this.direct = direct;
        this. result = result;
    }

    public String getSide(){
        return direct;
    }

    public String getResult(){
        return result;
    }

}
