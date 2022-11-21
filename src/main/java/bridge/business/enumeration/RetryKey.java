package bridge.business.enumeration;

public enum RetryKey {
    RETRY("R", true), NONE("Q", false);

    private final String key;
    private final boolean value;

    RetryKey(String key, boolean value){
        this.key = key;
        this.value = value;
    }

    public String getKey(){
        return this.key;
    }

    public boolean getValue(){
        return this.value;
    }
}
