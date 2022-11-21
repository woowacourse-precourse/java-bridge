package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovementCommandGeneratorTest {

    MovementCommandGenerator movementCommandGenerator;

    @BeforeEach
    public void init(){
        movementCommandGenerator = new MovementCommandGenerator();
    }

    @DisplayName("허용 입력(위: U, 아래: D) 생성")
    @ParameterizedTest
    @ValueSource(strings = {"U","D"})
    public void createCodeInRange(String input){
        assertThat(movementCommandGenerator.generate(input))
                .isEqualTo(input);
    }

    @DisplayName("허용 입력(위: U, 아래: D) 이외의 문자를 입력하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"343","EE","SJFAJOE"})
    public void createCodeOutRange(String input){
        assertThatThrownBy(() -> movementCommandGenerator.generate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}