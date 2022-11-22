package model;

import validation.Validation;

public class Restart {
    private final String result;

    public Restart(String result) {
        Validation.ofRestart(result);
        this.result = result;
    }

    public boolean isRestart() {
        if (result.equals("R"))
            return true;
        return false;
    }
}
