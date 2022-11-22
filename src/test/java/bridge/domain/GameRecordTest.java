package bridge.domain;

import static bridge.Constants.DOWN;
import static bridge.Constants.UP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRecordTest {

    @Test
    @DisplayName("이동의 성공,실패 여부 기록 테스트")
    void 플레이어_이동_기록_테스트() {
        //given
        GameRecord gameRecord = new GameRecord();
        //when
        gameRecord.recordSuccess(UP);
        gameRecord.recordSuccess(DOWN);
        gameRecord.recordFail(UP);
        String expectedUp = "[O,  , X]";
        String expectedDown = "[ , O,  ]";
        //then
        assertThat(gameRecord.getUpLog().toString()).isEqualTo(expectedUp);
        assertThat(gameRecord.getDownLog().toString()).isEqualTo(expectedDown);
    }

    @Test
    @DisplayName("재시작할 경우 기록이 초기화된다.")
    void 재시작_기록_초기화_테스트() {
        //given
        GameRecord gameRecord = new GameRecord();
        gameRecord.recordSuccess(UP);
        //when
        gameRecord.retry();
        String nextRecord = gameRecord.getUpLog().toString();
        //then
        assertThat(nextRecord).isEqualTo("[]");
    }

    @Test
    @DisplayName("재시작할 경우 시도횟수가 증가한다.")
    void 재시작_시도횟수_증가_테스트() {
        //given
        GameRecord gameRecord = new GameRecord();
        int currentTryAttempts = gameRecord.getTryAttempts();
        //when
        gameRecord.retry();
        int nextTryAttempts = gameRecord.getTryAttempts();
        //then
        assertThat(nextTryAttempts).isEqualTo(currentTryAttempts + 1);
    }
}
