package bridge.domain;

public enum Moving {
    UP("U"),
    DOWN("D"),
    ;

    private final String direction;
    
    Moving(String direction) {
        this.direction = direction;
    }
}
