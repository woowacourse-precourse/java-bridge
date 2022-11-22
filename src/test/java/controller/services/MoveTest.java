package controller.services;

import model.Bridge;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("입력에 따라 순서대로 이동하며 이동한 지점이 접근 가능한 지점이었는지 확인.")
public class MoveTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeMap() {
        List<String> bridgeMap = List.of("D", "U", "U");
        bridgeGame = new BridgeGame(new Bridge(bridgeMap), new User());
    }

    @DisplayName("이동한 지점이 접근 가능한 지점이었다면 false를 반환.")
    @Test
    void moveToAccessiblePosition() {
        new ArrayList<>(List.of("D", "U", "U")).forEach(data ->
                assertThat(bridgeGame.move(data)).isFalse());
    }

    @DisplayName("이동한 지점이 접근 불가능한 지점이었다면 true를 반환.")
    @Test
    void moveToInaccessiblePosition() {
        assertThat(bridgeGame.move("U")).isTrue();
    }
}
