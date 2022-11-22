package bridge.domain;

import bridge.domain.map.BridgeMap;
import bridge.domain.map.BridgeMark;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static bridge.domain.map.BridgeMark.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeMapTest {

    @DisplayName("다리 지도는 방향과 이동 결과에 따라 생성된다.")
    @Test
    void BridgeMapAddResultTest() {
        //given
        BridgeMap map = new BridgeMap();

        //when
        map.addResult("U", true);
        List<BridgeMark> up = map.getUp();
        List<BridgeMark> down = map.getDown();

        //then
        assertThat(up).containsExactly(START,DELIMITER,CORRECT,END);
        assertThat(down).containsExactly(START,DELIMITER,BLANK,END);
    }

    @DisplayName("init 호출시 다리 지도는 초기화 된다.")
    @Test
    void initTest() {
        // given
        BridgeMap map = new BridgeMap();
        map.addResult("U", true);
        map.addResult("D", true);

        // when
        map.init();

        // then
        assertThat(map.getUp().size())
            .isEqualTo(2);
        assertThat(map.getDown().size())
            .isEqualTo(2);
    }
}