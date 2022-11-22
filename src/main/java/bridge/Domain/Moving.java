package bridge.Domain;

import bridge.Controller.Validation;

public class Moving {
    String moving;

    public Moving(String moving){
        Validation.validateReadMoving(moving);
        this.moving = moving;
    }

    public String getMoving(){
        return moving;
    }
}
