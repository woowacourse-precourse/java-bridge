package model;

import type.MovingType;
import validation.Validation;

public class Moving {
    private final String result;

    public Moving(String result) {
        Validation.ofMoving(result);
        this.result = result;
    }

    public boolean isUpper() {
        if (result.equals("U"))
            return true;
        return false;
    }

    public String isMoving(Bridge bridge, int index) {
        if (bridge.getBridge(index).equals(result))
            return MovingType.MOVE.getResult();
        return MovingType.NOT_MOVE.getResult();
    }
}
