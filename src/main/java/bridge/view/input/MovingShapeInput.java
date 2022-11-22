package bridge.view.input;

import bridge.domain.value.MovingShape;
import camp.nextstep.edu.missionutils.Console;

import static bridge.utils.ViewMessages.MOVING;

public class MovingShapeInput implements Input<MovingShape> {
    @Override
    public MovingShape read() {
        System.out.println(MOVING);
        return new MovingShape(Console.readLine());
    }
}
