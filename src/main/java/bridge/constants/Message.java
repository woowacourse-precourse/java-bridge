package bridge.constants;

public enum Error {

    ERROR_PREFIX("[ERROR] ");

    private final String value;

    Error(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
