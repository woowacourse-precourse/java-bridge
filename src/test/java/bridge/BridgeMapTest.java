package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {
    @Test
    @DisplayName("초기 설정 후 String 변환값 비교")
    void initAndToString() throws Exception {
        //given
        BridgeMap bridgeMap = new BridgeMap();
        String expect = "[  ]\n[  ]\n";
        //when
        String result = bridgeMap.toString();
        //then
        assertThat(result).isEqualTo(expect);
    }
}