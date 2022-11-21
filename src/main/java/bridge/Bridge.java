package bridge;

public enum Bridge {
    FAILURE_UPPER("U", false),
    SUCCESS_UPPER("U", true),
    FAILURE_LOWER("D", false),
    SUCCESS_LOWER("D", true);

    private final String direct;
    private final boolean result;

    Bridge(String direct, boolean result){
        this.direct = direct;
        this. result = result;
    }

    public String getSide(){
        return direct;
    }

    public boolean getResult(){
        return result;
    }

}
