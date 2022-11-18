package bridge.enums;

public enum StringEnum {
    UP("U"),
    DOWN("D"),
    QUIT("Q"),
    RESTART("R");
    private final String key;
    private StringEnum(String key){
        this.key=key;
    }
    public String key(){
        return this.key;
    }
}
