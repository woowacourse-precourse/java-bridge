package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    private final BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());



    @Test
    @DisplayName("bridge_make_test")
    void bridge_make_test(){
        //given
        int sz = 5;

        //expected
        List<String> result = bm.makeBridge(sz);
        assertThat(result.size()).isEqualTo(5);

    }






}