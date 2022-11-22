package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator() {
            @Override
            public int generate() {
                return 1;
            }
        });
    }

    @DisplayName("랜덤 생성된 다리의 숫자가 1일 때 U 표현")
    @Test
    void displayUpRandomNumOne() {
        //given
        ArrayList<String> expectedBridge = new ArrayList<>();
        expectedBridge.add("U");
        int generatedNumber = 1;
        ArrayList<String> bridge = new ArrayList<>();

        //when
        bridgeMaker.makeUp(generatedNumber, bridge);

        //then
        assertArrayEquals(expectedBridge.toArray(), bridge.toArray());

    }

    @DisplayName("랜덤 생성된 다리의 숫자가 0일 때 D 표현")
    @Test
    void displayDownRandomNumZero() {
        //given
        ArrayList<String> expectedBridge = new ArrayList<>();
        expectedBridge.add("D");
        int generatedNumber = 0;
        ArrayList<String> bridge = new ArrayList<>();

        //when
        bridgeMaker.makeDown(generatedNumber, bridge);

        //then
        assertArrayEquals(expectedBridge.toArray(), bridge.toArray());

    }

    @DisplayName("다리의 길이에 맞춰서 랜덤으로 다리 생성하기")
    @Test
    void generateRandomBridge() {

        //given
        ArrayList<String> expectedBridge = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            expectedBridge.add("U");
        }

        //when
        List<String> bridge = bridgeMaker.makeBridge(5);

        //then
        assertArrayEquals(expectedBridge.toArray(), bridge.toArray());
    }
}
