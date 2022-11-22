package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Space down = Space.D;

        Space cross = down.cross();

        Assertions.assertThat(cross).isEqualTo(Space.U);
    }

    @Test
    void convertUpToDown() {
        Space up = Space.U;

        Space cross = up.cross();

        Assertions.assertThat(cross).isEqualTo(Space.D);
    }
}