package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    Bridge bridge;
    private final int size = 10;

    @BeforeEach
    void init(){
        bridge = new Bridge(size,new BridgeTestNumberGenerator());
    }

    @Test
    void createFalseByInputU(){
        assertThat(bridge.isCanCross(0,"U")).isEqualTo(false);
    }

    @Test
    void createTrueByInputU(){
        assertThat(bridge.isCanCross(0,"D")).isEqualTo(true);
    }

}