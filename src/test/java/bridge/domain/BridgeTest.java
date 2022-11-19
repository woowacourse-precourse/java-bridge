package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class BridgeTest {
    private static Bridge bridge;
    private static MockedStatic<Randoms> mock;

    @BeforeEach
    void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);
        BridgeLength bridgeLength = new BridgeLength(3);
        bridge = new Bridge(bridgeLength);
    }

    @AfterEach
    void afterEach() {
        mock.close();
    }

    @DisplayName("올바른 다리를 생성한다.")
    @Test
    void getBridge() {
        assertThat(bridge.getBridge()).containsExactly("U", "D", "U");
    }

    @DisplayName("올바른 다리의 길이를 반환한다.")
    @Test
    void getLength() {
        assertThat(bridge.getLength()).isEqualTo(3);
    }

    @DisplayName("다리를 추가하면 UnsupportedOperationException를 발생시킨다.")
    @Test
    void addBridge() {
        List<String> bridgeData = bridge.getBridge();
        assertThatThrownBy(() -> bridgeData.add("U"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("다리를 삭제하면 UnsupportedOperationException를 발생시킨다.")
    @Test
    void removeBridge() {
        List<String> bridgeData = bridge.getBridge();
        assertThatThrownBy(() -> bridgeData.remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("다리를 수정하면 UnsupportedOperationException를 발생시킨다.")
    @Test
    void modifyBridge() {
        List<String> bridgeData = bridge.getBridge();
        assertThatThrownBy(() -> bridgeData.set(0, "D"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
