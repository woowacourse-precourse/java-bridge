package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private static Stream<Arguments> provideValidSize() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(20),
                Arguments.of(5)
        );
    }

    @DisplayName("다리의 길이를 입력받아 해당 길이의 다리를 생성한다")
    @ParameterizedTest
    @MethodSource("provideValidSize")
    void buildBridgeCorrectly(int size) {
        //given
        List<String> generatedBridge = bridgeMaker.makeBridge(size);

        //when
        String convertedBridge = generatedBridge.toString();
        //정규식을 이용해 "[","]"," ",","을 제거
        convertedBridge = convertedBridge.replaceAll("[\\[\\],\\s']", "");

        //then
        assertThat(Pattern.matches("^[DU]{" + size + "}$", convertedBridge)).isTrue();
    }
}
