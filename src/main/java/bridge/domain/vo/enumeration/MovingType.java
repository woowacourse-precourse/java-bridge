package bridge.domain.vo.enumeration;

public enum MovingType {
    UP("U"),
    DOWN("D");

    private final String movingType;

    MovingType(String movingType){
        this.movingType = movingType;
    }

    public String getMovingType(){
        return this.movingType;
    }
}
