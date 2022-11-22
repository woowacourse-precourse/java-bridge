package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    Validation validation;

    @BeforeEach
    void init() {
        validation = new Validation();
    }

    @Nested
    @DisplayName("입력받은 값이 숫자인지 검증")
    class isDigit {
        @Test
        @DisplayName("숫자를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            validation.isDigit("3");
        }

        @Test
        @DisplayName("숫자이외의 값을 입력하면 예외가 발생한다")
        void wrongCase() {
            assertThatThrownBy(() -> validation.isDigit("a"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("3~20사이의 숫자인지 검증")
    class isInRange {
        @Test
        @DisplayName("3~20사이의 숫자를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            validation.isInRange(15);
        }

        @Test
        @DisplayName("3~20사이의 숫자를 입력하지 않으면 예외가 발생한다")
        void wrongCase() {
            assertThatThrownBy(() -> validation.isInRange(21))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("U또는 D를 입력했는지 검증")
    class validateMoving {
        @Test
        @DisplayName("U또는 D를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            validation.validateMoving("U");
        }

        @Test
        @DisplayName("U또는 D를 입력하지않으면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> validation.validateMoving("ABC"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("R또는 Q를 입력했는지 검증")
    class validateGameCommand {
        @Test
        @DisplayName("R또는 Q를 입력하면 예외가 발생하지 않는다.")
        void rightCase() {
            validation.validateGameCommand("R");
        }

        @Test
        @DisplayName("R또는 Q를 입력하지않으면 예외가 발생한다.")
        void wrongCase() {
            assertThatThrownBy(() -> validation.validateGameCommand("U"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}