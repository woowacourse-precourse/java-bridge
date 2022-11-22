package bridge.Domain;

import bridge.Controller.Validation;

public class Movement {
    String moving;

    public Movement(String moving){
        Validation.validateReadMoving(moving);
        this.moving = moving;
    }

    public String getMoving(){
        return moving;
    }
}
