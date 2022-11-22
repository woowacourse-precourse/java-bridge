package bridge.model.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MoveTest {

    @DisplayName("[ERROR] Move 예외 테스트")
    @Test
    void of() {
        //Given
        String[] move = new String[]{"1", "(", " "};

        //When
        assertThatThrownBy( () -> {
            for(int i = 0; i < move.length; i++){
                Move.of(move[i]);
            }
        }).isInstanceOf(IllegalArgumentException.class);

        //Then
    }
}