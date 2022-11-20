package model;

import java.util.List;

public class Bridge {

    List<String> moveChoices;
    public static final int LOWER_BOUND = 3;
    public static final int UPPER_BOUND = 20;

    public Bridge(List<String> moveChoices) {
        this.moveChoices = moveChoices;
    }

    public boolean movable(int position, String moveChoice) {
    }
}
