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

public class EndTest {
	Bridge bridgeLetters = new Bridge(List.of(UP, DOWN, UP, DOWN, UP));
	int bridgeLength = 5;
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, bridgeLength);

	@DisplayName("게임 진행 중 게임 종료 여부 확인")
	@Test
	void isEnd() {
		// given
		moveToWrongCell();

		// when
		if (PauseGame.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertThat(bridgeGame.isEnd()).isTrue();
	}

	private void moveToWrongCell() {
		String userSelectedCell = DOWN;
		bridgeGame.move(userSelectedCell);
	}

	@DisplayName("다리 완주 후 게임 종료 여부 확인")
	@Test
	void isEndWithComplete() {
		// given
		completeCrossBridge();

		// when
		if (PauseGame.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertThat(bridgeGame.isEnd()).isTrue();
	}

	private void completeCrossBridge() {
		String userSelectedCell = UP;
		bridgeGame.move(userSelectedCell);
		userSelectedCell = DOWN;
		bridgeGame.move(userSelectedCell);
		userSelectedCell = UP;
		bridgeGame.move(userSelectedCell);
		userSelectedCell = DOWN;
		bridgeGame.move(userSelectedCell);
		userSelectedCell = UP;
		bridgeGame.move(userSelectedCell);
	}
}
