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

    @Test
    @DisplayName("정답과 비교하여 boolean값 반환 테스트1")
    void 정답과_비교하여_boolean값_반환_테스트() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.initUserKeyList();
        bridge.move("U");
        bridge.move("U");
        boolean answer = bridge.isAnswer();
        assertThat(answer).isEqualTo(false);
    }

    @Test
    @DisplayName("정답과 비교하여 boolean값 반환 테스트2")
    void 정답과_비교하여_boolean값_반환_테스트2() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        bridge.initUserKeyList();
        bridge.move("U");
        bridge.move("D");
        bridge.move("U");
        boolean answer = bridge.isAnswer();
        assertThat(answer).isEqualTo(true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}