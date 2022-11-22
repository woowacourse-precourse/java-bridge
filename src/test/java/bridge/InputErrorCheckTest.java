package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static bridge.InputErrorCheck.readBridgeSizeErrorCheck;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputErrorCheckTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리 사이즈 입력 시 형식에 맞지 않는 값 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"asd","one","i"," ","\n","-1","1","22"})
    void BridgeSizeIsOutofFormat(String input){
        assertThatThrownBy(()->
                readBridgeSizeErrorCheck(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}