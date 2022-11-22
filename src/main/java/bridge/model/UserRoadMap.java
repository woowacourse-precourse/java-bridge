package bridge.model;

import bridge.constant.message.GameErrorMessage;
import java.util.List;

public class UserRoadMap extends RoadMap {
    public UserRoadMap(List<String> directions) {
        super(directions);
    }

    @Override
    protected void validate(List<String> directions) {
    }

    public Road getRoad(int roadPosition) {
        if (roadPosition < getSize()) {
            return this.roads.get(roadPosition);
        }
        throw new IllegalStateException(GameErrorMessage.NO_SUCH_ROAD_POSITION.getMessage());
    }

    public void clear() {
        this.roads.clear();
    }

    public void addRoad(String direction) {
        this.roads.add(new Road(direction));
    }
}
