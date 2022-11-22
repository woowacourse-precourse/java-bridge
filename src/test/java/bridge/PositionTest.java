package bridge;

import bridge.position.Latitude;
import bridge.position.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @Test
    @DisplayName("두 Position 객체의 필드 값이 같을 때 true 를 반환하는지 확인한다.")
    void equals() {
        Position position1 = new Position(0, Latitude.UP);
        Position position2 = new Position(0, Latitude.UP);
        Assertions.assertThat(position1.equals(position2)).isEqualTo(true);
    }

    @Test
    @DisplayName("두 Position 객체의 필드 값이 다를 때 false 를 반환하는지 확인한다.")
    void notEquals() {
        Position position1 = new Position(0, Latitude.UP);
        Position position2 = new Position(0, Latitude.DOWN);
        Position position3 = new Position(1, Latitude.DOWN);
        Assertions.assertThat(position1.equals(position2)).isEqualTo(false);
        Assertions.assertThat(position2.equals(position3)).isEqualTo(false);
    }
}
