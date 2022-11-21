package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {

    @DisplayName("입력 다리 길이만큼 다리를 생성한다.")
    @ParameterizedTest
    @CsvSource({"3,3", "10,10", "20,20"})
    void createRightSizeBridgeMaker(int size, int expected) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(expected);
    }

    @DisplayName("반환되는 리스트의 값에 U와 D만 있어야 합니다.")
    @Test
    void createRightReturnBridgeMaker () {
        List<String> makeBridgeResult;
        String[] rightAlphabet = {"U","D"};
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        makeBridgeResult = bridgeMaker.makeBridge(7);
        for (int i=0; i<makeBridgeResult.size(); i++) {
            assertThat(rightAlphabet).contains(makeBridgeResult.get(i));
        }
    }
}