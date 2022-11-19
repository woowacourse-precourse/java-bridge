package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private int distance = 0;
    private List<Movement> route = new ArrayList<>();
    private List<Boolean> answer = new ArrayList<>();

    public boolean matchPlayerAndBridge(Bridge bridge) {
        List<String> bridgeValues = bridge.getBridge();
        for (int i = 0; i < distance; i++ ) {
            if (!bridgeValues.get(i).equals(route.get(i).getDirection())) {
                return false;
            }
        }
        return true;
    }
    public void updateMovement(Movement movement) {
        distance += 1;
        route.add(movement);
    }

    public void updateAnswer(Boolean Answer) {
        answer.add(Answer);
    }

    public int getDistance() {
        return distance;
    }

    public List<Movement> getRoute() {
        return route;
    }

    public List<Boolean> getAnswer() {
        return answer;
    }

}
