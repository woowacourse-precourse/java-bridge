package bridge.view;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import bridge.domain.constants.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputHandlerTest {

    @DisplayName("Unvalidated BridgeSize Range")
    @ParameterizedTest(name = "[{index}] input \"{0}\" ")
    @ValueSource(strings = {"a", "@", " ", "ㄱ", "ㅁㄴㅇㄹ", "1,23ㅁㄴ"})
    void Unvalidated_BridgeSize_exception(String input) {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            new InputHandler().stringToInt(input);
        });
        assertEquals(ErrorCode.SIZE_NOT_IN_RANGE.getException().getMessage(),
                exception.getMessage());
    }
}