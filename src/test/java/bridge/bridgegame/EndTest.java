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

public class EndTest {
	Bridge bridgeLetters = new Bridge(List.of(UP, DOWN, UP, DOWN, UP));
	int bridgeLength = 5;
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, bridgeLength);
	Pause pause = new Pause();

	@DisplayName("게임 진행 중 게임 종료 여부 확인")
	@Test
	void isEnd() {
		// given
		String userSelectedCell = DOWN;
		bridgeGame.move(userSelectedCell);

		// when
		if (pause.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertAll(
			() -> assertThat(bridgeGame.isEnd()).isTrue(),
			() -> assertThat(pause.isPaused()).isFalse()
		);
	}

	@DisplayName("다리 완주 후 게임 종료 여부 확인")
	@Test
	void isEndWithComplete() {
		// given
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

		// when
		if (pause.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertAll(
			() -> assertThat(bridgeGame.isEnd()).isTrue(),
			() -> assertThat(pause.isPaused()).isFalse()
		);
	}
}
