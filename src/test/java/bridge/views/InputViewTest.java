package bridge.views;

import bridge.messages.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    InputView inputView = new InputView();

    void setInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Nested
    @DisplayName("read bridge size test")
    class ReadBridgeSizeTest {
        @Test
        @DisplayName("valid bridge size")
        public void validBridgeSizeTest() {
            String input = "3";
            setInput(input);
            assertThat(inputView.readBridgeSize()).isEqualTo(3);
        }

        @Test
        @DisplayName("invalid bridge size : read non numeric value")
        void notNumericValueAsBridgeSizeTest() {
            String input = "w";
            setInput(input);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThrows(NoSuchElementException.class, () -> {
                inputView.readBridgeSize();
                assertThat(out.toString()).contains(ErrorMessage.PREFIX_ERROR_MESSAGE.getMessage());
            });
        }

        @Test
        @DisplayName("invalid bridge size : shorter than minimum(3)")
        void tooShortBridgeSizeTest() {
            String input = "2";
            setInput(input);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThrows(NoSuchElementException.class, () -> {
                inputView.readBridgeSize();
                assertThat(out.toString()).contains(ErrorMessage.PREFIX_ERROR_MESSAGE.getMessage());
            });
        }

        @Test
        @DisplayName("invalid bridge size : longer than maximum(20)")
        void tooLongBridgeSizeTest() {
            String input = "21";
            setInput(input);
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            assertThrows(NoSuchElementException.class, () -> {
                inputView.readBridgeSize();
                assertThat(out.toString()).contains(ErrorMessage.PREFIX_ERROR_MESSAGE.getMessage());
            });
        }
    }

    @Nested
    @DisplayName("read moving test")
    class ReadMovingTest {

        @Test
        @DisplayName("valid moving direction(Up : U or u, Down : D or d)")
        void validMovingDirection() {
            String[] inputs = { "U", "D", "u", "d" };
            for (String input : inputs) {
                setInput(input);
                assertDoesNotThrow(() -> {
                    inputView.readMoving();
                });
            }
        }

        @Test
        @DisplayName("invalid moving direction(any characters cause an exception except for U or D)")
        void invalidMovingDirection() {
            String[] inputs = { "s", "UD", "3", "UP", "Down" };
            for (String input : inputs) {
                setInput(input);
                OutputStream out = new ByteArrayOutputStream();
                assertThrows(NoSuchElementException.class, () -> {
                    inputView.readMoving();
                    assertThat(out.toString()).contains(ErrorMessage.PREFIX_ERROR_MESSAGE.getMessage());
                });
            }
        }
    }

    @Nested
    @DisplayName("read retry input test")
    class readRetryTest {

        @Test
        @DisplayName("valid retry inputs(Retry : R or r, Quit : Q or q)")
        void validRetryInput() {
            String[] inputs = { "R", "r", "Q", "q" };
            for (String input : inputs) {
                setInput(input);
                assertDoesNotThrow(() -> {
                    inputView.readGameCommand();
                });
            }
        }

        @Test
        @DisplayName("invalid retry inputs")
        void invalidRetryInput() {
            String[] inputs = { "W", "RR", "QR", "QUIT", "123" };
            for (String input : inputs) {
                setInput(input);
                assertThrows(NoSuchElementException.class, () -> {
                    OutputStream out = new ByteArrayOutputStream();
                    inputView.readGameCommand();
                    assertThat(out.toString()).contains(ErrorMessage.PREFIX_ERROR_MESSAGE.getMessage());
                });
            }
        }
    }
}