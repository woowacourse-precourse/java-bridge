package bridge.business.enumeration;

public enum MovingKey {
    UP("U"), DOWN("D");

    private final String key;

    MovingKey(String key){
        this.key = key;
    }

    public String getKey(){
        return this.key;
    }
}
