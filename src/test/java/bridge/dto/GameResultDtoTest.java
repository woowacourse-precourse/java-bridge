package bridge.dto;

import bridge.enums.BridgeMark;
import bridge.enums.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.dto.GameResultDto.GameRecordDto;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultDtoTest {

    GameResultDto gameResult;

    @BeforeEach
    void setUp() {
        GameRecordDto gameRecord = new GameRecordDto(List.of(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN), 3);
        gameResult = new GameResultDto(GameStatus.SUCCESS, gameRecord);
    }

    @DisplayName("게임 결과 dto 게임 상태 반환 값 확인")
    @Test
    void getGameStatus() {
        assertThat(gameResult.getGameStatus()).isEqualTo(GameStatus.SUCCESS);
    }

    @DisplayName("게임 결과 dto 게임 기록 반환 값 확인")
    @Test
    void getRecord() {
        GameRecordDto gameRecord = gameResult.getGameRecord();
        assertThat(gameRecord.getAttempt()).isEqualTo(3);
        assertThat(gameRecord.getRecord()).containsExactly(BridgeMark.UP, BridgeMark.UP, BridgeMark.DOWN);
    }
}