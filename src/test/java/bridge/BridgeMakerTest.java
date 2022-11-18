package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest extends NsTest {

    private final String RANDOM_BRIDGE_WORD = "makeRandomBridgeWord";
    private final BridgeMaker maker = new BridgeMaker();

    private Method invokeMethod(String declared) throws NoSuchMethodException {
        Method method = maker.getClass().getDeclaredMethod(declared, int.class);
        method.setAccessible(true);
        return method;
    }

    @DisplayName("랜덤 숫자가 1이면 U, 아니면 D를 반환한다.")
    @CsvSource(value = {"1:U", "0:D"}, delimiter = ':')
    @ParameterizedTest(name = "{index} {displayName} test={0}")
    void returnRandomWordTest(int bridgeNumber, String expected) throws Exception {
        Method method = invokeMethod(RANDOM_BRIDGE_WORD);
        assertThat(method.invoke(maker, bridgeNumber)).isEqualTo(expected);
    }

    @DisplayName("다리 생성 테스트")
    @Test
    void createBridgeTest() {
        BridgeNumberGenerator numberGenerator =
                new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(4);
        assertThat(bridge).containsExactly("U", "D", "U", "U");
    }

    @Override
    protected void runMain() {

    }
}
