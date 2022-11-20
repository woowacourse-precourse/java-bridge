package bridge.exceptionTest;
import bridge.exception.GameCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameCommandExceptionTest {

    GameCommandException gameCommandException;

    @BeforeEach
    void initializeClass(){
        gameCommandException = new GameCommandException();
    }

    @DisplayName("입력이 Q, R이 아니면 예외처리")
    @Test
    void validateWrongTest(){
        assertThatThrownBy(()->gameCommandException.validate("NO"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 Q이면 그대로 반환")
    @Test
    void validateQTest(){
        assertThat(gameCommandException.validate("Q")).isEqualTo("Q");
    }

    @DisplayName("입력이 R이면 그대로 반환")
    @Test
    void validateRTest(){
        assertThat(gameCommandException.validate("R")).isEqualTo("R");
    }
}
