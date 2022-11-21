package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameCommandValidatorTest {
    @DisplayName("게임 재시작을 입력 받을 때, R이나 Q가 아닌 경우")
    @ValueSource(strings = {"12","QA","Z"})
    @ParameterizedTest
    void checkGameCommand(String input){
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class,
                ()->GameCommandValidator.checkGameCommand(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] R이나 Q를 입력해야합니다.");
    }

}