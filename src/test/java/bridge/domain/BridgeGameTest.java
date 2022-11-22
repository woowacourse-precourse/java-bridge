package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
	Bridge bridge;
	BridgeGame bridgeGame;
	ProgressMap gameProgress;
	List<List<String>> expect;
	String upInput = "U";
	String downInput = "D";

	@BeforeEach
	void setup() {
		bridge = new Bridge(List.of("U", "D", "U"));
		bridgeGame = new BridgeGame(bridge);
		gameProgress = new ProgressMap();
		expect = new ArrayList<>();
	}

	@Test
	@DisplayName("결과 반영 테스트")
	void correctMoveTest() {
		expect.add(List.of("O", " ", "O"));
		expect.add(List.of(" ", "O", " "));
		bridgeGame.move(upInput, gameProgress);
		bridgeGame.move(downInput, gameProgress);
		bridgeGame.move(upInput, gameProgress);
		assertEquals(expect, gameProgress.getProgressMap());
	}

	@Test
	@DisplayName("게임을 통과하지 못했을 때 결과 테스트")
	void incorrectMoveTest() {
		expect.add(List.of("O", "X"));
		expect.add(List.of(" ", " "));
		bridgeGame.move(upInput, gameProgress);
		bridgeGame.move(upInput, gameProgress);
		assertEquals(expect, gameProgress.getProgressMap());
	}
}
