package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {

    private Location location;

    @BeforeEach
    void setUp() {
        location = new Location();
        location.init();
    }

    @DisplayName("다음 위치로 정상 이동되는지 확인")
    @Test
    void checkMovementWorkingProperly() {
        int moveCount = 5;
        for (int i = 0; i < moveCount; i++) {
            location.moveNext();
        }

        assertThat(location.getLocation()).isEqualTo(moveCount);
    }

    @DisplayName("위치 초기화가 정상적으로 되는지 확인")
    @Test
    void checkLocationInitiation() {
        location.moveNext();
        location.init();

        assertThat(location.getLocation()).isEqualTo(0);
    }
}
