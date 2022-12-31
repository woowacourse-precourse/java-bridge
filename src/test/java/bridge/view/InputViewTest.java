package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

//    @DisplayName("다리 길이가 숫자가 아닌 경우에 대한 예외 처리")
//    @CsvSource({"k","&&","f4j"})
//    @ParameterizedTest
//    void nonNumericBridgeLength(String string) {
//        InputStream in = generateUserInput(string);
//        System.setIn(in);
//
//        assertThatThrownBy(() -> InputView.readBridgeSize())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ERROR_MESSAGE);
//    }
//
//    @DisplayName("다리 길이가 3이상 20이하가 아닌 경우에 대한 예외 처리")
//    @CsvSource({"2","-33","100"})
//    @ParameterizedTest
//    void outOfRangeBridgeLength(String string) {
//        InputStream in = generateUserInput(string);
//        System.setIn(in);
//
//        assertThatThrownBy(() -> InputView.readBridgeSize())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ERROR_MESSAGE);
//    }
//
//    @DisplayName("이동할 칸이 U 또는 D가 아닌 경우에 대한 예외 처리")
//    @CsvSource({"k","...","4","X","ㄸ어모ㅓㅊ"})
//    @ParameterizedTest
//    void invalidType(String string) {
//        InputStream in = generateUserInput(string);
//        System.setIn(in);
//
//        assertThatThrownBy(() -> InputView.readMoving())
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessageContaining(ERROR_MESSAGE);
//    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
}