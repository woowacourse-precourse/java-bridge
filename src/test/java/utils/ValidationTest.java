package utils;

import static constant.ErrorMessage.ERROR_HEAD_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *  추가적인 예외사항은 없는가??
 */
class ValidationTest {
    private Validation validation;

    @BeforeEach
    void setUp() {
        this.validation = new Validation();
    }

    /**
     *  빈 문자열("")은 NumberFormatException 예외 발생
     */
    @DisplayName("")
    @ParameterizedTest
    @CsvSource(value = {"NULL", "''", "a", "-1", "2", "21"},
            nullValues = "NULL")
    void 입력값_테스트(String input) {
        assertThatThrownBy(() -> {
            validation.validBridgeSize(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_HEAD_MESSAGE);
    }


    @DisplayName("3이상 20이하의 값이 입력될 때 정상적으로 기능하는지 테스트한다.")
    @ParameterizedTest
    @ValueSource(strings = {"3","20"})
    void 경계_안쪽값_테스트(String value) {
        assertThatNoException().isThrownBy(() -> {
            validation.validBridgeSize(value);
        });
    }
}
