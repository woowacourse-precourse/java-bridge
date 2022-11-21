package bridge.model;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @Test
    void matchAll_test(){
        Bridge answer = new Bridge(List.of("U", "U", "D"));
        Bridge input = new Bridge(List.of("U", "U", "D"));
        assertThat(input.matchAll(answer)).isEqualTo(true);
    }

    @Test
    void matchCurrentState_test(){
        Bridge answer = new Bridge(List.of("U", "U", "D"));
        Bridge input = new Bridge(List.of("U", "U"));
        assertThat(input.matchCurrentState(answer)).isEqualTo(true);
    }

    @Test
    void findWrongIndex_test(){
        Bridge answer = new Bridge(List.of("U", "U", "D"));
        Bridge input = new Bridge(List.of("U", "D"));
        assertThat(input.findWrongIndex(answer)).isEqualTo(1);
    }

    @Test
    void exception_test(){
        assertThatThrownBy(()->{
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeMaker.makeBridge(2);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}