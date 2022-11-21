package bridge.service.constants;

public enum Move {

    UP_BRIDGE("U"),
    DOWN_BRIDGE("D");

    private final String value;

    Move(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
