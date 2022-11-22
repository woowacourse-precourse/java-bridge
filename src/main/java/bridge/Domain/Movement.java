package bridge.Domain;

import bridge.Controller.Validation;

public class Movement {
    private String moving;

    public Movement(String moving){
        Validation.validateMoving(moving);
        this.moving = moving;
    }

    public String getMoving(){
        return moving;
    }
}
