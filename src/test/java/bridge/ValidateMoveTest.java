package bridge;
import bridge.valid.ValidateMove;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateMoveTest extends NsTest {
    @Override
    protected void runMain(){}

    @Nested
    @DisplayName("사용자 이동값 입력의 유효성 검사")
    class ValidateMoveInput{
        @DisplayName("입력값이 한글자가 아닐때")
        @ParameterizedTest
        @ValueSource(strings = {"UP","DOWN","UD","DU","UU","DD"})
        public void lengthFail(String value){
            assertThatThrownBy(()->new ValidateMove().validateMove(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 U,D 이외의 한글자가 들어온경우")
        @ParameterizedTest
        @ValueSource(strings = {"A","Z","u","d"})
        public void wordFail(String value){
            assertThatThrownBy(()->new ValidateMove().validateMove(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 정상적으로 들어온 경우")
        @ParameterizedTest
        @ValueSource(strings = {"U","D"})
        public void success(String value){
            assertThat(new ValidateMove().validateMove(value))
                    .isEqualTo(value);
        }
    }
}
