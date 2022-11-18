package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private Map<Movement, List<String>> movementStatus;

    public Player() {
        this.movementStatus = new HashMap<>() {{
            put(Movement.U, new ArrayList<>());
            put(Movement.D, new ArrayList<>());
        }};
    }
    public Map<Movement, List<String>> getMovementStatus() {
        return Collections.unmodifiableMap(movementStatus);
    }


    public void crossOverBridge(Movement move, boolean isMoveble) {
        for(Map.Entry<Movement, List<String>> bridge: movementStatus.entrySet()) {
            String status = " ";
            if(bridge.getKey() == move) {
                status = calculateStatusAfterMove(isMoveble);
            }
            bridge.getValue().add(status);
        }
    }

    public String calculateStatusAfterMove(boolean isMoveble){
        if(isMoveble) {
            return "O";
        }
        return "X";
    }

}
