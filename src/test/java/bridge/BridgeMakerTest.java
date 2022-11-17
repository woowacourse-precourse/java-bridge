package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
public class BridgeMakerTest extends NsTest {

    @Override
    protected void runMain(){
    }

    @Nested
    @DisplayName("다리 생성이 정상적으로 되는지 확인")
    class workBridgeMakeWell{
        @DisplayName("랜덤하게 생성되는 0,1에따라 U(위),D(아래)로 정상 치환 확인")
        @ParameterizedTest
        @CsvSource(value={"1:U","0:D"},delimiter = ':')
        public void convertSuccess(int value,String expected){
            assertThat(new BridgeMakeHelper().decideBridgeAnswer(value))
                    .isEqualTo(expected);
        }

        @DisplayName("변환된 U(위),D(아래)가 Bridge에 추가가 잘되는지 확인")
        @ParameterizedTest
        @ValueSource(strings = {"U","D"})
        public void appendSuccess(String value){
            List<String> bridge=new ArrayList<>();
            new BridgeMakeHelper().appendBridge(bridge,value);
            assertThat(bridge.contains(value)).isTrue();
        }

        @DisplayName("생성된 다리의 길이가 입력받은 값이 맞는지 확인")
        @ParameterizedTest
        @ValueSource(ints = {3,9,10,11,20})
        public void checkBridgeLengthsuccess(int value){
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator=new BridgeRandomNumberGenerator();
            assertThat(new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(value).size())
                    .isEqualTo(value);
        }
    }


}
