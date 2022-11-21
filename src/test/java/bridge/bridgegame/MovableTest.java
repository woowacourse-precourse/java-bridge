package bridge.bridgegame;

import static bridge.Constants.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.Pause;

public class MovableTest {
	Bridge bridgeLetters = new Bridge(List.of(UP, DOWN, UP, DOWN, UP));
	int bridgeLength = 5;
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, bridgeLength);

	@DisplayName("선택한 칸이 이동 가능한 칸인지 확인")
	@Test
	void isMovable() {
		// given
		String userSelectedCell = UP;

		// when
		boolean isMovable = bridgeGame.isMovable(bridgeLetters, userSelectedCell);

		// then
		assertThat(isMovable).isTrue();
	}

	@DisplayName("한 칸 이동한 뒤, 선택한 칸이 이동 불가능한 칸인 경우")
	@Test
	void isNotMovable() {
		// given
		String userSelectedCell = UP;
		bridgeGame.move(userSelectedCell);
		userSelectedCell = UP;

		// when
		boolean isMovable = bridgeGame.isMovable(bridgeLetters, userSelectedCell);

		// then
		assertAll(
			() -> assertThat(isMovable).isFalse(),
			() -> assertThat(Pause.isPaused()).isTrue()
		);
	}
}
