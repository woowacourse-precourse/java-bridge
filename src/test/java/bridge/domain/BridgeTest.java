package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {

    @Test
    void 다리길이_테스트1(){
        assertThatThrownBy(()-> new Bridge(new ArrayList<>(List.of(1,0)))).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 다리길이_테스트2(){
        assertThatThrownBy(()-> new Bridge(new ArrayList<>(List.of(1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다리구별_숫자_테스트(){
        assertThatThrownBy(()-> new Bridge(new ArrayList<>(List.of(1,0,2)))).isInstanceOf(IllegalArgumentException.class);
    }
}