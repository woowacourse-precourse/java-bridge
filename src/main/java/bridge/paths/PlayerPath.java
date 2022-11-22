package bridge.paths;

import bridge.identifiers.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerPath {

    private static int ordinalNumber = 0;
    private List<Direction> currentPath = new ArrayList<>();

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
}
