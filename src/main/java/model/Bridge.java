package model;

import java.util.List;

public class Bridge {
    List<MoveChoice> moveChoices;


    public boolean movable(int position, MoveChoice moveChoice){
        return false;
    };
}
