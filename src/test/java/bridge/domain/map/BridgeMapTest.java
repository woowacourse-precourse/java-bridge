package bridge.domain.map;

import bridge.domain.game.CrossingDecision;
import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.*;

class BridgeMapTest {

	private static final List<String> bridgeMocked = newArrayList("U", "U", "D");

	@AfterEach
	@BeforeEach
	void clearMap() {
		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다: 첫회이면서 맞는 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FromBeginning_AsIsCorrect() {
		BridgeMap bridgeMap = setUp("U", 1);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[ O ]");
		List<String> expected2 = List.of("[   ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다: 첫회이면서 틀린 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FromBeginning_AsIsWrong() {
		BridgeMap bridgeMap = setUp("D", 1);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[   ]");
		List<String> expected2 = List.of("[ X ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다: 2회 이상이면서 맞는 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FollowingBeginning_AsIsCorrect() {
		BridgeMap bridgeMap = setUp("U", 2);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[ O ", "| O ]");
		List<String> expected2 = List.of("[   ", "|   ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다: 2회 이상이면서 틀린 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FollowingBeginning_AsIsWrong() {
		BridgeMap bridgeMap = setUp("D", 2);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[   ", "|   ]");
		List<String> expected2 = List.of("[ X ", "| X ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);
	}

	private static BridgeMap setUp(String movementCommandMocked, int repeatedCounts) {
		MovementCommand movementCommand = MovementCommand.valueOf(movementCommandMocked);
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);
		BridgeMap bridgeMap = BridgeMap.constructedBy(crossingDecision, movementCommand);

		for (int i = 1; i < repeatedCounts; i++) {
			bridgeMap = BridgeMap.constructedBy(crossingDecision, movementCommand);
		}

		return bridgeMap;
	}
}

