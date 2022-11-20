package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
	List<String> bridge;
	BridgeGame bridgeGame;
	ProgressMap gameProgress;

	@BeforeEach
	void setup() {
		bridge = new ArrayList<>(List.of("U", "D", "U"));
		bridgeGame = new BridgeGame(bridge);
		gameProgress = new ProgressMap();
	}

	@Test
	@DisplayName("결과 반영 테스트")
	void correctMoveTest() {
		String input = "U";
		String input2 = "D";
		String input3 = "U";
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of(" O ", "   ", " O "));
		expect.add(List.of("   ", " O ", "   "));
		bridgeGame.move(input, gameProgress);
		bridgeGame.move(input2, gameProgress);
		bridgeGame.move(input3, gameProgress);

		assertEquals(expect, gameProgress.getProgressMap());
	}

	@Test
	@DisplayName("게임을 통과하지 못했을 때 결과 테스트")
	void incorrectMoveTest() {
		String input = "U";
		String input2 = "U";
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of(" O ", " X "));
		expect.add(List.of("   ", "   "));

		bridgeGame.move(input, gameProgress);
		bridgeGame.move(input2, gameProgress);

		assertEquals(expect, gameProgress.getProgressMap());
	}
}
