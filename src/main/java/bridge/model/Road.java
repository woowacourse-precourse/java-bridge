package bridge.model;

public class Road {
    private final String direction;

    public Road(String direction){
        validate(direction);
        this.direction = direction;
    }

    private void validate(String direction){
        // TODO: 방향의 유효성 확인
    }

    public boolean match(String direction){
        // TODO: 방향 일치 여부를 확인
        return false;
    }
}
