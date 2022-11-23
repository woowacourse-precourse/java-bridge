package bridge.domain.game;

import bridge.domain.map.BridgeMap;
import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

class ResultRenderingTest {

	@AfterEach
	@BeforeEach
	void clearMap() {
		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("다리 건너기 결과에 대한 String 변환 결과 출력을 검증한다")
	@Test
	void verify_ResultRendering_CanRenderBridgeDescription_AsProperlyDesignedString() {
		BridgeMap bridgeMap = setUp();

		String actual = ResultRendering.generatedBy(bridgeMap).getBridgeRendered();
		String expected = "[   ]" + "\n" + "[ X ]";

		assertThat(actual).isEqualTo(expected);
	}

	@DisplayName("최종 결과 출력을 검증한다")
	@Test
	void verify_ResultRendering_CanRenderFinalResult_AsAssignedFormat() {
		BridgeMap bridgeMap = setUp();
		ResultRendering.generatedBy(bridgeMap);

		HashMap<String, Integer> gameResultMocked = new HashMap<>();
		gameResultMocked.put("실패", 3);

		String actual = ResultRendering.renderFinalResult(gameResultMocked);
		String expected = "최종 게임 결과" + "\n" + "[   ]" + "\n" + "[ X ]" + "\n\n"
				+ "게임 성공 여부: 실패" + "\n" + "총 시도한 횟수: 3";

		assertThat(actual).isEqualTo(expected);
	}

	private static BridgeMap setUp() {
		MovementCommand movementCommand = MovementCommand.valueOf("D");
		List<String> bridgeMocked = newArrayList("U", "U", "D");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);

		return BridgeMap.constructedBy(crossingDecision, movementCommand);
	}
}
