package bridge;

import bridge.dto.GameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.record(BridgeMark.UP);
        player.record(BridgeMark.DOWN);
    }

    @DisplayName("플레이어가 움직인 마크 기록 확인")
    @Test
    void record() {
        GameResultDto responseDto = player.toResponseDto();
        List<BridgeMark> record = responseDto.getRecord();

        assertThat(record).containsExactly(BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("플레이어가 움직인 기록을 초기화")
    @Test
    void clearRecord() {
        player.clear();
        GameResultDto responseDto = player.toResponseDto();
        List<BridgeMark> record = responseDto.getRecord();

        assertThat(record.size()).isEqualTo(0);
    }

    @Test
    void increaseAttempt() {
        player.increaseAttempt();
        player.increaseAttempt();
        GameResultDto responseDto = player.toResponseDto();

        assertThat(responseDto.getAttempt()).isEqualTo(3);
    }
}
