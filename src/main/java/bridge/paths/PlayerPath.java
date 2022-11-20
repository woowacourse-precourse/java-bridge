package bridge.paths;

import bridge.identifiers.Direction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerPath {

    private List<Direction> currentPath = new ArrayList<>();

    public PlayerPath(){}

    public void saveDirection(Direction direction){
        currentPath.add(direction);
    }

    public List<Direction> getPath(){
        return Collections.unmodifiableList(currentPath);
    }
}
