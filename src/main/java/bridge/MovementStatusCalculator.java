package bridge;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MovementStatusCalculator {
    private final Deque<MovementStatusForm> movementStatus = new LinkedList<>();
    private int step_count = 0;

    public Deque<MovementStatusForm> saveMovementStatus(String movement_code, List<String> bridge){

        if(bridge.get(step_count).equals(movement_code)){
            movementStatus.add(MovementStatusForm.createPassCaseByCode(movement_code));
            step_count++;
            return movementStatus;
        }

        movementStatus.add(MovementStatusForm.createWrongCaseByCode(movement_code));
        step_count++;

        return movementStatus;
    }
}
