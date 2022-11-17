package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import bridge.model.BridgeSize;

public class BridgeSizeTest extends NsTest {

    @Override
    protected void runMain(){}

    @Nested
    @DisplayName("다리의 길이 입력 유효성 검사")
    class ValidateBridgeSize{

        @DisplayName("입력된 다리길이에 문자가 섞여있는 경우")
        @ParameterizedTest
        @ValueSource(strings = {"5a","b5","10c","1c3","c15"})
        public void wordFail(String value){
            assertThatThrownBy(()->new BridgeSize(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력된 다리길이가 지정된 범위를 벗어나는 경우")
        @ParameterizedTest
        @ValueSource(strings={"0","1","-5","21","2","40","10000"})
        public void rangeFail(String value){
            assertThatThrownBy(()->new BridgeSize(value))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("입력값이 정상적으로 들어온 경우")
        @ParameterizedTest
        @ValueSource(strings={"3","9","10","19","20"})
        public void success(String value){
            assertThat(new BridgeSize(value).getSize()).isEqualTo(Integer.parseInt(value));
        }
    }
}
