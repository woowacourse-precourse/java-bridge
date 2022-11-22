package bridge.model.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {
    @ParameterizedTest
    @DisplayName("소문자가 입력된 경우")
    @ValueSource(strings = {"u", "d", "d", "u"})
    void isLowerCase(String input) {
        assertThatThrownBy(() -> Move.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("U, D가 아닌 다른 문자")
    @ValueSource(strings = {"Z", "B", "S", "T"})
    void isIncorrectData(String input) {
        assertThatThrownBy(() -> Move.of(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("Parameter int : 정확한 값이 들어오는지 여부 확인 1")
    @Test
    void isCorrectDataIntCase1() {
        //given
        int input = 1;
        //when
        //then
        assertEquals("U", Move.of(input).getMoveKey());
    }

    @DisplayName("Parameter String : 정확한 값이 들어오는지 여부 확인 1")
    @Test
    void isCorrectDataStringCase1() {
        //given
        String input = "U";
        //when
        //then
        assertEquals("U", Move.of(input).getMoveKey());
    }

    @DisplayName("정확한 값이 들어오는지 여부 확인 2")
    @Test
    void isCorrectDataIntCase2() {
        //given
        int input = 0;
        //when
        //then
        assertEquals("D", Move.of(input).getMoveKey());
    }

    @DisplayName("정확한 값이 들어오는지 여부 확인 3")
    @Test
    void isCorrectDataStringCase2() {
        //given
        String input = "D";
        //when
        //then
        assertEquals("D", Move.of(input).getMoveKey());
    }
}