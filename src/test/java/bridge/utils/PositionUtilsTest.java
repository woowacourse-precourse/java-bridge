package bridge.utils;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.type.RetryType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PositionUtilsTest {

    @Test
    void 플레이어가_선택한_위치와_건널수_있는_다리를_비교() {
        // given
        Player player = new Player();
        Bridge bridge = new Bridge(List.of("U", "D", "D"));

        player.selectPosition("U");
        int start = 0;

        // when
        boolean result = PositionUtils.compareTo(player, bridge, start);

        assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(strings = "R")
    void 이동결과에_따라_재시작문구_출력_및_입력_테스트(String input) {
        // given
        InputStream in = generateConsoleInput(input);
        System.setIn(in);
        boolean isPass = false;

        // when
        RetryType result = PositionUtils.toRetryType(isPass);

        // then
        assertThat(result).isEqualTo(RetryType.RETRY);
        afterSetting();
    }

    private InputStream generateConsoleInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }
    private static void afterSetting() {
        System.setIn(System.in);
    }
}
