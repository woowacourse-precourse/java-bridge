package bridge;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    private static final InputView INPUT_VIEW = new InputView();

    @DisplayName("readBridgeSize 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3", "5", "10", "14", "17", "20"})
    void readBridgeSize_test(String input){
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        int result=INPUT_VIEW.readBridgeSize();
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }
    @DisplayName("readBridgeSize 예외 사항 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "5j", " 10", "1", "2", "-1", "21"})
    void readBridgeSize_exception_test(String input){
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(()->INPUT_VIEW.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("readMoving 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    void readMoving_test(String input){
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        String result = INPUT_VIEW.readMoving();
        assertThat(result).isEqualTo(input);
    }
    @DisplayName("readMoving 예외 사항 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"u","d", " ", "aa"})
    void readMoving_exception_test(String input){
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        assertThatThrownBy(()->INPUT_VIEW.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("readGameCommand 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"R","Q"})
    void readGameCommand_test(String input){
        byte[] buf = input.getBytes();
        System.setIn(new ByteArrayInputStream(buf));
        String result = INPUT_VIEW.readGameCommand();
        assertThat(result).isEqualTo(input);
    }
    @DisplayName("tryParse 예외 사항 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1000j", "", " ", "1 3", "1a3", "1,2,3", " 1", "1 "})
    void tryParseInt_exception_test(String testInput) {
        assertThatThrownBy(() -> INPUT_VIEW.tryParseInt(testInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("checkRange 예외 사항 테스트")
    @ParameterizedTest
    @CsvSource({"1,3,20", "-10,3,30", "21,3,20", "2,3,20"})
    void checkRange_exception_test(ArgumentsAccessor arguments) {
        assertThatThrownBy(() -> INPUT_VIEW.checkRange(arguments.getInteger(0)
                , arguments.getInteger(1), arguments.getInteger(2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("isPermittedCommand 예외 사항 테스트")
    @ParameterizedTest
    @CsvSource({"u,U,D,R,Q", "d,U,D,R,Q", "r,U,D,R,Q", "q,U,D,R,Q", "a,U,D,R,Q"})
    void isPermittedCommand_exception_test(ArgumentsAccessor arguments) {
        assertThatThrownBy(() -> INPUT_VIEW.isPermittedCommand(arguments.getString(0)
                , List.of(arguments.getString(1),
                        arguments.getString(2),
                        arguments.getString(3),
                        arguments.getString(4))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}