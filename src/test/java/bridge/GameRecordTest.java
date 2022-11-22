package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameRecordTest {

    private final GameRecord gameRecord = new GameRecord();

    @Test
    @DisplayName("게임 초기화 할때마다 playTime은 1씩 증가")
    void updatePlayTimeAndGetPlayTime() {
        gameRecord.initialize();
        gameRecord.initialize();

        assertThat(gameRecord.getPlayTime()).isEqualTo(2);
    }

    @Test
    @DisplayName("정상적으로 다리기록이 만들어 졌을때")
    void makeBridgeRecordByRightInput() {
        gameRecord.addRecord("U", true);
        gameRecord.addRecord("D", true);
        gameRecord.addRecord("D", false);

        assertThat(gameRecord.makeBridgeRecord()).isEqualTo("[ O |   |   ]\n[   | O | X ]\n");
    }

    @Test
    @DisplayName("레코드가 없다면 결과에는 O나 X가 들어있지 않아야 한다.")
    void recordClear() {
        gameRecord.addRecord("U", true);

        gameRecord.initialize();

        assertThat(gameRecord.makeBridgeRecord().toCharArray()).doesNotContain('O', 'X');
    }

    @Test
    @DisplayName("게임이 성공했다면 true를 반환한다.")
    void whenGameSuccess() {
        gameRecord.addRecord("D", true);

        assertThat(gameRecord.isGameSuccess()).isTrue();
    }

    @Test
    @DisplayName("게임이 실패했다면 false를 반환한다.")
    void whenGameFailure() {
        gameRecord.addRecord("D", false);

        assertThat(gameRecord.isGameSuccess()).isFalse();
    }
}