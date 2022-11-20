package bridge.bridgegame;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.Pause;

public class EndTest {
	Bridge bridgeLetters = new Bridge(List.of("U", "D", "U", "D", "U"));
	BridgeGame bridgeGame = new BridgeGame(bridgeLetters, 5);

	@DisplayName("게임 진행 중 게임 종료 여부 확인")
	@Test
	void isEnd() {
		// given
		String userSelectedCell = "D";
		bridgeGame.move(userSelectedCell);

		// when
		if (Pause.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertAll(
			() -> assertThat(bridgeGame.isEnd()).isTrue(),
			() -> assertThat(Pause.isPaused()).isFalse()
		);
	}

	@DisplayName("다리 완주 후 게임 종료 여부 확인")
	@Test
	void isEndWithComplete() {
		// given
		String userSelectedCell = "U";
		bridgeGame.move(userSelectedCell);
		userSelectedCell = "D";
		bridgeGame.move(userSelectedCell);
		userSelectedCell = "U";
		bridgeGame.move(userSelectedCell);
		userSelectedCell = "D";
		bridgeGame.move(userSelectedCell);
		userSelectedCell = "U";
		bridgeGame.move(userSelectedCell);

		// when
		if (Pause.isPaused()) {
			bridgeGame.end();
		}

		// then
		assertAll(
			() -> assertThat(bridgeGame.isEnd()).isTrue(),
			() -> assertThat(Pause.isPaused()).isFalse()
		);
	}
}
