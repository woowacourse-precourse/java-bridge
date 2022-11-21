package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class BridgeMakerTest {


    BridgeMaker bridgeMaker;
    private List<Integer> testNumbers;

    @BeforeEach
    void init(){
        testNumbers = new ArrayList<>(Arrays.asList(0,1,0,1));
        bridgeMaker = new BridgeMaker(new BridgeTestNumberGenerator(testNumbers));
    }

    @Test
    void checkBridgeSize(){
        List<String> bridge = bridgeMaker.makeBridge(testNumbers.size());
        assertThat(bridge.size()).isEqualTo(4);
    }

    @Test
    void checkBridgeBySameStringList(){
        List<String> bridge = bridgeMaker.makeBridge(testNumbers.size());
        assertThat(bridge).isEqualTo(List.of("D","U","D","U"));
    }

}