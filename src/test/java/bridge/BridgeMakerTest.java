package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest extends NsTest {

    public BridgeMaker bridgeMaker;

    @BeforeEach
    public void setUp() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    @DisplayName("생성되는 정답 다리의 길이가 사용자의 요구와 같은가 - 같은 경우 ")
    @ValueSource(ints = {1, 3, 5, 7, 11})
    @ParameterizedTest
    void checkBridgeMakerException1(int inputLength) {
        List<String> answerBridgeMade = bridgeMaker.makeBridge(inputLength);
        Assertions.assertThat(answerBridgeMade.size()).isEqualTo(inputLength);
    }

    @DisplayName("생성되는 정답 다리가 \"U\", \"D\" 만으로 구성되어 있는가 - U,D로만 되어 있는 경우 ")
    @ValueSource(ints = {1, 3, 5, 7, 11, 500})
    @ParameterizedTest
    void checkBridgeMakerException2(int inputLength) {
        List<String> answerBridgeMade = bridgeMaker.makeBridge(inputLength);
        Assertions.assertThat(answerBridgeMade.stream().
                filter(c -> c.equals("U")).filter(c -> c.equals("D")).count()).isEqualTo(0);
    }

    @DisplayName("입력이 유효하지 않다면 적당한 에러 메세지를 던지는가 - 음수, 0 일 때 ")
    @ValueSource(ints = {0, -3, -10, -5})
    @ParameterizedTest
    void checkBridgeMakerException3(int inputLength) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(inputLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}