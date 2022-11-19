package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @DisplayName("다리 생성 메서드")
    @Test
    void makeBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        assertEquals(List.of("[   ]", "[   ]", "[   ]"), bridgeMaker.makeBridge(3));
    }

    @DisplayName("다리 리스트 생성 메서드")
    @Test
    void makeBridgeList() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<Bridge> bridgeList = List.of(new Bridge(List.of("[   ]", "[   ]", "[   ]")), new Bridge(List.of("[   ]", "[   ]", "[   ]")));
        assertThat(bridgeList).usingRecursiveComparison().isEqualTo(bridgeMaker.makeBridgeList(3));
    }

}