package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void beforeEach() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("0, 1 을 넣었을 때 List에 옳바르게 D, U이 들어가는지 확인하는 테스트")
    void inputBridgeInformationTest() {

        List<Integer> inputList = List.of(0, 1, 0, 1, 0, 0, 1, 1);
        List<String> expectedList = List.of("D", "U", "D", "U", "D", "D", "U", "U");
        List<String> resultList = new ArrayList<>();

        for (int index = 0; index < inputList.size(); index++) {
            bridgeMaker.inputBridgeInformation(resultList, inputList.get(index));
        }

        assertThat(resultList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("다리의 길이에 맞게 Bridge가 생성되는지 확인하는 테스트")
    void makeBridgeTest() {

        int bridgeSize = 15;

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }
}