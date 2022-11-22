package bridge;

import bridge.enums.BridgeMark;
import bridge.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.dto.GameResultDto.GameRecordDto;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.record(BridgeMark.UP);
        player.record(BridgeMark.DOWN);
    }

    @DisplayName("플레이어의 게임 기록 확인")
    @Test
    void getGameRecord() {
        GameRecordDto gameRecord = player.toGameRecordDto();
        assertThat(gameRecord.getAttempt()).isEqualTo(1);
        assertThat(gameRecord.getRecord()).containsExactly(BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("플레이어가 움직인 마크 기록 확인")
    @Test
    void record() {
        GameRecordDto gameRecord = player.toGameRecordDto();
        List<BridgeMark> record = gameRecord.getRecord();

        assertThat(record).containsExactly(BridgeMark.UP, BridgeMark.DOWN);
    }

    @DisplayName("플레이어가 움직인 기록 초기화")
    @Test
    void clearRecord() {
        player.clearRecord();
        GameRecordDto gameRecord = player.toGameRecordDto();
        List<BridgeMark> record = gameRecord.getRecord();

        assertThat(record.size()).isEqualTo(0);
    }

    @DisplayName("플레이어의 게임 시도 횟수 증가 후 결과 확인")
    @Test
    void increaseAttempt() {
        player.increaseAttempt();
        player.increaseAttempt();
        GameRecordDto gameRecord = player.toGameRecordDto();

        assertThat(gameRecord.getAttempt()).isEqualTo(3);
    }
}
