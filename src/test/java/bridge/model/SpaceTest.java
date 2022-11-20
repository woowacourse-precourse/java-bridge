package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceTest {
    private static final int UP_NUMBER = 1;
    private static final int DOWN_NUMBER = 0;

    @Test
    void createSpaceWithDownNumber() {
        int downNumber = 0;

        Space down = Space.from(DOWN_NUMBER);

        Assertions.assertThat(down).isEqualTo(Space.D);
    }

    @Test
    void createSpaceWithUpNumber() {
        int upNumber = 1;

        Space up = Space.from(UP_NUMBER);

        Assertions.assertThat(up).isEqualTo(Space.U);
    }

    @Test
    void convertDownToUp() {
    }

    @Test
    void convertUpToDown() {
    }
}