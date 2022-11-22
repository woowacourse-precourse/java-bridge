package bridge.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeComparatorTest {
    BridgeComparator bridgeComparator =new BridgeComparator();
    @Test
    void  isSameTest(){
        List<String> userBridge = new ArrayList<>();
        List<String> computerBridge = new ArrayList<>();
        userBridge.add("U");
        computerBridge.add("U");
        computerBridge.add("D");
        assertThat(bridgeComparator.isSame(userBridge,computerBridge)).isTrue();
        userBridge.add("U");
        assertThat(bridgeComparator.isSame(userBridge,computerBridge)).isFalse();
    }// isSameTest
}//end class
