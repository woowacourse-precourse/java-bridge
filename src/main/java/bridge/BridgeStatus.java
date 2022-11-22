package bridge;

public enum BridgeStatus {
    FALSE(-1),
    QUIT("Q"),
    RETRY("R"),
    UP("U"),
    DOWN("D");
    private Object value;
    BridgeStatus( Object desc){
        this.value = desc;
    }

    public int getValueInteger(){
        return (int) value;
    }
    public String getValueString(){
        if(this.value.equals(-1)){
            return "-1";
        }
        return (String) this.value;
    }
}

