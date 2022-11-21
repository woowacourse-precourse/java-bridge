package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ColumnTest {
    @DisplayName("입력된 문자가 잘못되면 예외처리 한다")
    @ParameterizedTest
    @CsvSource({"t", "-1", "u", "3"})
    void inputBridgeLengthByNotNumeric(String input) {
        assertThatThrownBy(() -> Column.valueOfCapitalLetter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이동한 칸과 정답을 비교 한다")
    @ParameterizedTest
    @CsvSource({"U,D,false", "U,U,true", "D,D,true"})
    void validateToCrossByRandomNumber(String answer, String input, boolean expected) {
        Column answerColumn = Column.valueOfCapitalLetter(answer);
        Column inputColumn = Column.valueOfCapitalLetter(input);
        boolean actual = answerColumn.equals(inputColumn);
        assertThat(actual).isEqualTo(expected);
    }
    @DisplayName("입력된 문자에 맞는 열거형을 반환한다")
    @ParameterizedTest
    @CsvSource({"D,DOWN_ROW", "U,TOP_ROW"})
    void validateToCrossByRandomNumber(String answer, Column expected) {
        Column actual = Column.valueOfCapitalLetter(answer);
        assertThat(actual).isEqualTo(expected);
    }




}