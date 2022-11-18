package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

	@Test
	@DisplayName("결과 반영 테스트")
	void moveTest() {
		List<String> bridge = new ArrayList<>(List.of("U", "D", "U"));
		BridgeGame bridgeGame = new BridgeGame(bridge);
		List<List<String>> gameProgress = new ArrayList<>();
		String input = "U";
		String input2 = "D";
		String input3 = "U";
		List<List<String>> expect = new ArrayList<>();
		expect.add(List.of("O"," ","O"));
		expect.add(List.of(" ", "O"," "));

		gameProgress.add(new ArrayList<>());
		gameProgress.add(new ArrayList<>());
		bridgeGame.move(input, gameProgress);
		bridgeGame.move(input2, gameProgress);
		bridgeGame.move(input3, gameProgress);

		assertEquals(expect,gameProgress);
	}
}
