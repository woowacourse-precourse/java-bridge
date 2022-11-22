package bridge.model;

import java.util.List;
import java.util.stream.Collectors;

public abstract class RoadMap {
    protected final List<Road> roads;

    protected RoadMap(List<String> directions) {
        validate(directions);
        this.roads = directions.stream().map(direction -> new Road(direction)).collect(Collectors.toList());
    }

    protected abstract void validate(List<String> directions);

    public int getSize() {
        return this.roads.size();
    }

    public boolean matchPositionWithDirection(int roadPosition, String direction) {
        if (roadPosition < getSize()) {
            return this.roads.get(roadPosition).matchDirection(direction);
        }
        return false;
    }

    public boolean matchPositionWithRoad(int roadPosition, Road road) {
        if (roadPosition < getSize()) {
            return this.roads.get(roadPosition).matchRoad(road);
        }
        return false;
    }
}
