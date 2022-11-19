package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Nested
    @DisplayName("readBridgeSize 테스트")
    class ReadBridgeSizeTest {

        @ParameterizedTest
        @DisplayName("성공")
        @ValueSource(strings = {"3", "4", "19", "20"})
        void readBridgeSize_validInput_returnInt(String string) {
            // given
            InputStream in = new ByteArrayInputStream(string.getBytes());
            InputView inputView = new InputView();

            // when
            System.setIn(in);

            // then
            assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(string));
        }

        @ParameterizedTest
        @DisplayName("실패")
        @ValueSource(strings = {"A", "3.0", "2", "21"})
        void readBridgeSize_InvalidInput_ExceptionThrown(String string) {
            // given
            InputStream in = new ByteArrayInputStream(string.getBytes());
            InputView inputView = new InputView();

            // when
            System.setIn(in);

            // then
            assertThrows(IllegalArgumentException.class, inputView::readBridgeSize);
        }
    }

    @Nested
    @DisplayName("readMoving 테스트")
    class ReadMovingTest {

        @ParameterizedTest
        @DisplayName("성공")
        @ValueSource(strings = {"U", "D"})
        void readMoving_validInput_returnString(String string) {
            // given
            InputStream in = new ByteArrayInputStream(string.getBytes());
            InputView inputView = new InputView();

            // when
            System.setIn(in);

            // then
            assertThat(inputView.readMoving()).isEqualTo(string);
        }

        @ParameterizedTest
        @DisplayName("실패")
        @ValueSource(strings = {"A", "Hello, world!"})
        void readMoving_InvalidInput_ExceptionThrown(String string) {
            // given
            InputStream in = new ByteArrayInputStream(string.getBytes());
            InputView inputView = new InputView();

            // when
            System.setIn(in);

            // then
            assertThrows(IllegalArgumentException.class, inputView::readMoving);
        }
    }
}
