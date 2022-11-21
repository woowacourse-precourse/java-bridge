package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PlayerDataTest {
    @DisplayName("움직인방향 기록하기")
    @Test
    void addMovement() {
        PlayerData playerData = new PlayerData();
        playerData.add("U");
        playerData.add("U");
        playerData.add("D");
        assertThat(playerData.getMovementRecord()).isEqualTo(List.of("U", "U", "D"));
    }

    @DisplayName("움직인 기록 모두 삭제하기")
    @Test
    void clearMovementRecord() {
        PlayerData playerData = new PlayerData();
        playerData.add("U");
        playerData.add("U");
        playerData.add("D");
        playerData.clearMovementRecord();
        assertThat(playerData.getMovementRecord()).isEqualTo(List.of());
    }

    @DisplayName("마지막으로 움직인기록 인덱스 가져오기")
    @Test
    void getIndexOfMovementRecord() {
        PlayerData playerData = new PlayerData();
        playerData.add("U");
        playerData.add("U");
        playerData.add("D");
        assertThat(playerData.getIndexOfMovementRecord()).isEqualTo(2);
    }

    @DisplayName("시도한 횟수 1 증가시키기")
    @Test
    void increaseCountOfTry() {
        PlayerData playerData = new PlayerData();
        playerData.increaseCountOfTry();
        assertThat(playerData.getCountOfTry()).isEqualTo(2);
    }
}
