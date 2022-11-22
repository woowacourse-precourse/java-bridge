package bridge.value;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeCharacterTest {

    @ParameterizedTest
    @CsvSource({"0","1"})
    void 값에_해당하는_글자_테스트(int value) {
        BridgeCharacter.makeBridgeCharacter(value);
    }

    @ParameterizedTest
    @CsvSource({"-1","3"})
    void 값에_해당하는_글자_예외_테스트(int value) {
        assertThatThrownBy(() -> BridgeCharacter.makeBridgeCharacter(value)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"U","D"})
    void 문자에_해당하는_글자_테스트(String character) {
        BridgeCharacter.makeBridgeCharacter(character);
    }

    @ParameterizedTest
    @CsvSource({"0", "1", "M", "UP", "DOWN", "ETC"})
    void 문자에_해당하는_글자_예외_테스트(String character) {
        assertThatThrownBy(() -> BridgeCharacter.makeBridgeCharacter(character)).isInstanceOf(
                IllegalArgumentException.class);
    }
}