package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PassingSpaceTest {

    @Test
    void testToString() {
        PassingSpace passingSpace = new PassingSpace();
        passingSpace.add(Space.U, Movable.O);
        passingSpace.add(Space.D, Movable.X);
        String result = "[ O |   ]\n[   | X ]\n";

        Assertions.assertThat(passingSpace.toString()).isEqualTo(result);
    }
}