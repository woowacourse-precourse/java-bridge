package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentRouteTest {

    private CurrentRoute currentRoute;

    @BeforeEach
    void setUp() {
        currentRoute = new CurrentRoute();
    }

    @DisplayName("다음 위치로 정상 이동되는지 확인")
    @Test
    void checkMovementWorkingProperly() {
        int moveCount = 5;
        String[] movements = {"D", "D", "U", "U", "U"};
        for (int i = 0; i < moveCount; i++) {
            currentRoute.moveNext(movements[0]);
        }

        assertThat(currentRoute.getCurrentLocationIndex()).isEqualTo(moveCount - 1);
    }

    @DisplayName("위치 초기화가 정상적으로 되는지 확인")
    @Test
    void checkLocationInitiation() {
        currentRoute.moveNext("D");
        currentRoute.clear();

        assertThat(currentRoute.getCurrentLocationIndex()).isEqualTo(-1);
    }
}
