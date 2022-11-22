package bridge.util;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMapUpdaterTest {

    BridgeMapUpdater bridgeMapUpdater;

    @BeforeEach
    void beforeEach() {
        bridgeMapUpdater = new BridgeMapUpdater();
    }

    @DisplayName("이동했을때 맵이 잘 업데이트 되는지 테스트")
    @Test
    void updateMapTest() {
        //given
        int preLocation = 0;
        int location = 1;
        boolean pass = true;
        String moveUp = "U";
        String moveDown = "D";
        bridgeMapUpdater.setMap(preLocation, pass, moveUp);
        bridgeMapUpdater.setMap(location, pass, moveDown);

        //when
        String result = bridgeMapUpdater.getUpdatedBridgeMap();

        //then
        assertThat("[ O |   ]\n[   | O ]").isEqualTo(result);
    }

    @DisplayName("맵이 잘 초기화되는지 테스트")
    @Test
    void clearMapTest() {
        //given
        int location = 0;
        boolean pass = true;
        String moveUp = "U";
        bridgeMapUpdater.setMap(location, pass, moveUp);
        bridgeMapUpdater.clearMap();

        //when
        String result = bridgeMapUpdater.getUpdatedBridgeMap();

        //then
        assertThat("[  ]\n[  ]").isEqualTo(result);
    }
}
