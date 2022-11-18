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

    public boolean match(String direction){
        // TODO: 방향 일치 여부를 확인
        return false;
    }
}
