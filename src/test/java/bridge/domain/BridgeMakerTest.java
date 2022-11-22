package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    void 랜덤값이_0이면_D_입력() {
        BridgeMaker b = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = new ArrayList<>();
        int random = 0;
        assertThat(b.checkRandom(bridge, random).get(0)).isEqualTo("D");
    }

    @Test
    void 랜덤값이_1이면_U_입력() {
        BridgeMaker b = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = new ArrayList<>();
        int random = 1;
        assertThat(b.checkRandom(bridge, random).get(0)).isEqualTo("U");
    }

}