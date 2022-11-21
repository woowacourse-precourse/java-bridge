package bridge.model;

import bridge.model.Bridge;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {
    MockedStatic<Randoms> randomsMockedStatic;

    @BeforeEach
    void beforeAll() {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0,1)).thenReturn(1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0);
    }

    @AfterEach
    void afterEach() {
        randomsMockedStatic.close();
    }

    @DisplayName("Bridge 객체 생성 테스트")
    @Test
    void newBridgeTest() {
        assertThat(new Bridge(3))
                .isInstanceOf(Bridge.class);
        assertThat(new Bridge(10))
                .isInstanceOf(Bridge.class);
        assertThat(new Bridge(20))
                .isInstanceOf(Bridge.class);
    }

    @DisplayName("Bridge 객체 생성 예외 테스트")
    @Test
    void newBridgeExceptionTest() {
        assertThatThrownBy(() -> new Bridge(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bridge(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Bridge(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("도착한 곳이 건널 수 있는 곳인지 아닌지 체크하는 메소드")
    @Test
    void possibleNextStepTest() {
        Bridge bridge = new Bridge(20);

        boolean indexZeroIsUp = bridge.possibleNextStep(0, Plate.UP_PLATE);
        boolean indexZeroIsNotDown = bridge.possibleNextStep(0, Plate.DOWN_PLATE);

        assertThat(indexZeroIsUp).isTrue();
        assertThat(indexZeroIsNotDown).isFalse();
    }

    @DisplayName("플레이어 경로와 다리를 비교하는 테스트")
    @Test
    void sameAsTest() {
        Bridge bridge = new Bridge(20);

        List<Plate> playerPath = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            playerPath.add(Plate.UP_PLATE);
            playerPath.add(Plate.DOWN_PLATE);
        }

        assertThat(bridge.sameAs(playerPath)).isTrue();
    }
}
