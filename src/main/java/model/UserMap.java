package model;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
    private String[][] mapOfMove;
    private Map<String,Integer> table;

    public UserMap(int bridgeSize){
        mapOfMove = new String[2][bridgeSize];
        table = new HashMap<>();
        table.put("D",0);
        table.put("U",1);
    }

    public void setContinue(String direction,int distance){
        mapOfMove[table.get(direction)][distance] = "O";
        mapOfMove[1-table.get(direction)][distance] = " ";
    }

    public void setStop(String direction,int distance){
        mapOfMove[table.get(direction)][distance] = "X";
        mapOfMove[1-table.get(direction)][distance] = " ";
    }

    public String[][] getMapOfMove() {
        return mapOfMove;
    }
}
