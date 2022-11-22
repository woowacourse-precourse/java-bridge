package bridge.bridgegame;

import static bridge.util.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.domain.Bridge;
import bridge.service.BridgeGame;
import bridge.service.PauseGame;

public class RetryTest {
	Bridge bridgeLetters = new Bridge(List.of(UP, DOWN, UP, DOWN, UP));
	int bridgeLength = 5;
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, bridgeLength);

	@DisplayName("게임 재시작 여부 확인")
	@Test
	void isRetry() {
		// given
		String userSelectedCell = DOWN;
		bridgeGame.move(userSelectedCell);

		// when
		if (PauseGame.isPaused()) {
			bridgeGame.retry();
		}
		String nextUserSelectedCell = UP;

		// then
		assertAll(
			() -> assertThat(bridgeGame.isMovable(bridgeLetters, nextUserSelectedCell)).isTrue(),
			() -> assertThat(PauseGame.isPaused()).isFalse()
		);
	}
}
