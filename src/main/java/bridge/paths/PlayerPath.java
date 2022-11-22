package bridge.paths;

import bridge.identifiers.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerPath {

    private static int ordinalNumber = 0;
    private final List<Direction> currentPath = new ArrayList<>();
    private boolean isAlive = true;

    public PlayerPath(){
        ++ordinalNumber;
    }

    public void saveDirection(Direction direction){
        currentPath.add(direction);
    }

    public List<Direction> getPath(){
        return Collections.unmodifiableList(currentPath);
    }
    public int getOrdinalNumber(){
        return ordinalNumber;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void die(){
        isAlive = false;
    }
}
