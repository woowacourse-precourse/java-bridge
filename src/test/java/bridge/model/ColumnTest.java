package bridge.model;

import bridge.exception.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ColumnTest {
    @DisplayName("이동할 때 공백이 입력 되는 경우 예외처리.")
    @Test
    void inputMoveLetterByBlank() {
        assertThatThrownBy(() -> ValidationUtils.letter(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("이동할 때 다른 문자가 입력 되는 경우 예외처리.")
    @ParameterizedTest
    @CsvSource({"t", "-1", "u", "I"})
    void inputMoveLetterByAnotherLetter(String input) {
        assertThatThrownBy(() -> ValidationUtils.letter(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("대문자(입력문자)를 비교 후 값이 같은 경우 참을 반환한다")
    @ParameterizedTest
    @CsvSource({"DOWN_ROW,true", "TOP_ROW,false"})
    void compareCapitalLetter(Column answer, boolean expected) {
        Column column = Column.valueOfCapitalLetter("D");
        assertThat(column.equals(answer)).isEqualTo(expected);
    }

//    @DisplayName("입력된 문자가 잘못됐는지 이중으로 확인 후 예외처리 한다")
//    @ParameterizedTest
//    @CsvSource({"t", "-1", "u", "I"})
//    void validateMoveLetter(String input) {
//        assertThatThrownBy(() -> Column.valueOfCapitalLetter(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
    @DisplayName("입력된 문자에 맞는 열거형을 반환한다")
    @ParameterizedTest
    @CsvSource({"D,DOWN_ROW", "U,TOP_ROW"})
    void getEnumByCapitalLetter(String answer, Column expected) {
        Column actual = Column.valueOfCapitalLetter(answer);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("무작위 값이 0인 경우 아래 칸, 1인경우 위 칸이 건널 수 있는 칸이 된다")
    @ParameterizedTest
    @CsvSource({"1,U", "0,D"})
    void validateToCrossByRandomNumber(int number, String expected) {
        String actual = Column.changeNumToLetter(number);
        assertThat(actual).isEqualTo(expected);
    }


    @DisplayName("이동한 칸과 정답을 비교 한다")
    @ParameterizedTest
    @CsvSource({"U,D,false", "U,U,true", "D,D,true"})
    void compareMovedLetterByAnswer(String answer, String input, boolean expected) {
        Column answerColumn = Column.valueOfCapitalLetter(answer);
        Column inputColumn = Column.valueOfCapitalLetter(input);
        boolean actual = answerColumn.equals(inputColumn);
        assertThat(actual).isEqualTo(expected);
    }


}