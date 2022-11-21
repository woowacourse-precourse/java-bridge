package bridge;

import bridge.valid.ValidateGameCommand;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
public class GameCommandTest extends NsTest {

    @Override
    protected void runMain(){}

    @Nested
    @DisplayName("사용자 재시작 여부 입력값의 유효성 검사기능의 정상작동 확인")
    class ValidateInputCommand{
        @DisplayName("입력값이 한글자가 아닌경우")
        @ParameterizedTest
        @ValueSource(strings = {"RE","Re","Quit","QUIT","RQ","QR"})
        public void lengthFail(String value){
            assertThatThrownBy(()->new ValidateGameCommand().validateGameCommand(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 R,Q 이외의 한글자가 들어온 경우")
        @ParameterizedTest
        @ValueSource(strings = {"A","Z","q","r"})
        public void woldFail(String value){
            assertThatThrownBy(()->new ValidateGameCommand().validateGameCommand(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("정상적으로 입력값이 들어온 경우")
        @ParameterizedTest
        @ValueSource(strings = {"R","Q"})
        public void success(String value){
            assertThat(new ValidateGameCommand().validateGameCommand(value))
                    .isEqualTo(value);
        }
    }
}
