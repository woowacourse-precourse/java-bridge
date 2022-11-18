package bridge.model;

import bridge.constant.command.DirectionCommand;
import bridge.constant.message.GameErrorMessage;

public class Road {
    private final String direction;

    public Road(String direction){
        validate(direction);
        this.direction = direction;
    }

    private void validate(String direction){
        for(DirectionCommand command : DirectionCommand.values()){
            if(command.getValue().equals(direction)){
                return;
            }
        }
        throw new IllegalStateException(GameErrorMessage.NO_SUCH_DIRECTION.getMessage());
    }

    public boolean matchDirection(String direction){
        return this.direction.equals(direction);
    }

    public boolean matchRoad(Road other){
        // TODO: 현재 칸과 주어진 칸 일치 여부 확인
        return false;
    }
}
