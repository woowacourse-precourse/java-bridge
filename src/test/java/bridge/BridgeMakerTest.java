package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.from;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("다리가 길이에 맞게 생성되는지 테스트")
    @Test
    void createRandomBridge(){
        int size = 3;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> firstBridge = new ArrayList<>(bridgeMaker.makeBridge(size));

        assertEquals(firstBridge.size(),size);
    }
}