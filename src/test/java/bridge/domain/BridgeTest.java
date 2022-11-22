package bridge.domain;

import bridge.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

class BridgeTest extends NsTest {

    @Test
    @DisplayName("맵 생성 테스트")
    void OX_맵_생성_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.initUserKeyList();
        bridge.move("U");
        bridge.move("U");
        String[] map = bridge.getBridgeMap();
        assertThat(map).containsExactly("O", "X");
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}