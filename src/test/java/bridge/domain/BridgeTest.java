package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;
import java.util.List;

public class BridgeTest {
    private static Bridge bridge;
    private static MockedStatic<Randoms> mock;

    @BeforeEach
    void beforeEach() {
        mock = mockStatic(Randoms.class);
        mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                .thenReturn(1, 0, 1);
        bridge = new Bridge(3);
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

    @DisplayName("isCorrectPanel 메서드는 order에 해당하는 칸의 다리를 맞추면 true를 반환한다.")
    @ParameterizedTest(name = "{index}) Order : {0}, Choice: {1}")
    @CsvSource({ "1, U", "2, D", "3, U" })
    void checkCorrectPanel(int order, String choice) {
        assertThat(bridge.isCorrectPanel(order, choice)).isTrue();
    }

    @DisplayName("isCorrectPanel 메서드는 order에 해당하는 칸의 다리를 맞추지 못하면 false를 반환한다.")
    @ParameterizedTest(name = "{index}) Order : {0}, Choice: {1}")
    @CsvSource({ "1, D", "2, U", "3, D" })
    void checkIncorrectPanel(int order, String choice) {
        assertThat(bridge.isCorrectPanel(order, choice)).isFalse();
    }
}
