package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이 입력받는 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "10,10", "20,30"})
    void readBridgeSizeTest(String input, int expectedSize) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int size = inputView.readBridgeSize();
        assertThat(size).isEqualTo(expectedSize);
    }

    @DisplayName("다리 길이 입력받는 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10j", "jjj", "1j0", "j10", "j"})
    void readBridgeSizeExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
