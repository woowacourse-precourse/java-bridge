package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("플레이어가 움직인 마크 기록 확인")
    @Test
    void record() {
        Player player = new Player();
        player.record(BridgeMark.UP);
        player.record(BridgeMark.DOWN);

        PlayerResponseDto responseDto = player.toResponseDto();
        List<BridgeMark> record = responseDto.getRecord();

        assertThat(record).containsExactly(BridgeMark.UP, BridgeMark.DOWN);
    }
}
