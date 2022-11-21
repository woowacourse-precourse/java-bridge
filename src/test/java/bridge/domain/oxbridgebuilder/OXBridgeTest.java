package bridge.domain.oxbridgebuilder;

import bridge.domain.resources.UpOrDown;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class OXBridgeTest {

    OXBridge oxBridge;

    @BeforeEach
    void setOXBridge() {
        oxBridge = OXBridge.from();
    }

    @DisplayName("input에 대한 OX가 OXBridge에 잘 담기는지 확인하는 테스트")
    @MethodSource("addUDTestArgumentProvider")
    @ParameterizedTest
    void addUDTest(String inputUD, boolean correctOrWrong, String resultDesign) {
        oxBridge.addUD(UpOrDown.of(inputUD), correctOrWrong);
        Assertions.assertThat(oxBridge.toString()).isEqualTo(resultDesign);
    }

    private static Stream<Arguments> addUDTestArgumentProvider() {
        return Stream.of(
            Arguments.of("U", true, "[ O ]\n[   ]\n"),
            Arguments.of("U", false, "[ X ]\n[   ]\n"),
            Arguments.of("D", true, "[   ]\n[ O ]\n"),
            Arguments.of("D", false, "[   ]\n[ X ]\n")
        );
    }

}