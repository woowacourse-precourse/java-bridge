package bridge;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {

    @Test
    @DisplayName("다리 생성 테스트")
    void makeBridgeTest(){
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1,0,0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U","D","D");
    }

    static class TestNumberGenerator implements BridgeNumberGenerator{
        private final List<Integer> list;

        TestNumberGenerator(List<Integer> list){
            this.list = list;
        }
        @Override
        public int generate(){
            return list.remove(0);
        }
    }
}
