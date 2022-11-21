package bridge;

import bridge.model.Bridge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeTest {

    Bridge bridge = new Bridge(List.of("U","U","D","U","U","D"));
    List<String> moveInput = List.of("U","U","D","U","U","D");
    
    @Test
    void moveTest()
    {
        int position = 0;
        for (; position < bridge.length(); position++) {
            String nextMove = moveInput.get(position);
            Assertions.assertTrue(bridge.isMovable(position,nextMove));
        }
        Assertions.assertTrue(bridge.isFinish(position));
    }

    @Test
    void moveFailTest()
    {
        List<Integer> positions = List.of(2,5,0,5,2,3);

        for (int index = 0; index < bridge.length(); index++) {
            int position = positions.get(index);
            String nextMove = moveInput.get(index);
            Assertions.assertFalse(bridge.isMovable(position,nextMove));
        }
    }

    @Test
    void outOfIndexTest() {
        List<Integer> positions = List.of(-1,20,-5,13,10000,-12412);

        for (int position : positions) {
            Assertions.assertThrows(IndexOutOfBoundsException.class,
                    () -> bridge.isMovable(position,"D")
            );
        }
    }

    @Test
    void illegalInputTest() {
        List<String> moveInput = List.of("-1","A","14","M","FE","BE");
        List<Integer> positions = List.of(0,1,2,3,4,5);

        for (int i = 0; i < moveInput.size(); i++) {
            Assertions.assertFalse(bridge.isMovable(positions.get(i),moveInput.get(i)));
        }
    }

}
