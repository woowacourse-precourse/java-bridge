package bridge.util.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class BridgeLengthValidatorTest {
    BridgeLengthValidator bridgeLengthValidator;

    @BeforeEach
    void setUp() {
        bridgeLengthValidator = new BridgeLengthValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void 다리_길이_테스트(String input) {
        bridgeLengthValidator.validate(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "a", "3a","2","21"})
    void 다리_길이_예외_테스트(String input){
        assertThrows(IllegalArgumentException.class, () -> bridgeLengthValidator.validate(input));
    }

}