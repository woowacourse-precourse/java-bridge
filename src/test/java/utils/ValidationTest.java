package utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static utils.Validation.ERROR_HEAD_MESSAGE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        this.validation = new Validation();
    }

    @DisplayName("")
    @ParameterizedTest
    @CsvSource(value = {"NULL", "''", "a", "-1", "2", "21"},
            nullValues = "NULL")
    void 다리의_길이_예외_입력값_테스트(String input) {
        assertThatThrownBy(() -> {
            validation.validBridgeSize(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }


    @DisplayName("3이상 20이하의 값이 입력될 때 정상적으로 기능하는지 테스트한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3","20"})
    void 다리의_길이_경계값_테스트(String value) {
        assertThatNoException().isThrownBy(() -> {
            validation.validBridgeSize(value);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"NULL", "''", "u", "d", "1"}
                    , nullValues = "NULL")
    void 입력값이_U도_D도_아닐때_예외를_검증하는지_테스트(String input) {
        assertThatThrownBy(() -> {
            validation.validMovingNext(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void 입력값이_U_또는_D일때_정상_작동하는지_테스트(String input) {
        assertThatNoException().isThrownBy(() -> {
            validation.validMovingNext(input);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"NULL", "''", "r", "q", "1"}
            , nullValues = "NULL")
    void 입력값이_R도_Q도_아닐때_예외를_검증하는지_테스트(String input) {
        assertThatThrownBy(() -> {
            validation.validGameCommand(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void 입력값이_R_또는_Q일때_정상_작동하는지_테스트(String input) {
        assertThatNoException().isThrownBy(() -> {
            validation.validGameCommand(input);
        });
    }
}
