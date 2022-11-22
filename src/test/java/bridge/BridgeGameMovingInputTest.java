package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameMovingInputTest {

    @Test
    @DisplayName("BridgeGameMovingInput 생성: key 값이 존재하면 Enum 반환")
    void givenValidKeys_whenCreateBridgeGameMovingInput_thenReturnInstance() {
        Stream<String> tests = Stream.of("U", "D");
        tests.forEach(test -> assertThat(BridgeGameMovingInput.fromKey(test)).isNotNull());
    }

    @Test
    @DisplayName("BridgeGameMovingInput 생성: key 값이 없으면 null 반환")
    void givenInvalidKeys_whenCreateBridgeGameMovingInput_thenReturnNull() {
        Stream<String> tests = Stream.of("Q", "R", "hello");
        tests.forEach(test -> assertThat(BridgeGameMovingInput.fromKey(test)).isNull());
    }
}
