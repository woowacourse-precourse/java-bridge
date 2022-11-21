package bridge.domain.map;

import bridge.domain.game.CrossingDecision;
import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMapTest {

	@DisplayName("BridgeMap의 리스트 구조를 검증한다 : 첫회, 맞는 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FromBeginning_AsIsCorrect() {
		MovementCommand movementCommand = MovementCommand.valueOf("U");
		List<String> bridgeMocked = List.of("U", "U");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);

		BridgeMap bridgeMap = BridgeMap.constructedBy(crossingDecision, movementCommand);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[ O ]");
		List<String> expected2 = List.of("[   ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);

		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다 : 첫회, 틀린 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FromBeginning_AsIsWrong() {
		MovementCommand movementCommand = MovementCommand.valueOf("D");
		List<String> bridgeMocked = List.of("U", "U");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);

		BridgeMap bridgeMap = BridgeMap.constructedBy(crossingDecision, movementCommand);

		List<String> actual1 = bridgeMap.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap.getUnderBridgeDescription();

		List<String> expected1 = List.of("[   ]");
		List<String> expected2 = List.of("[ X ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);

		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다 : 2회 이상, 맞는 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FollowingBeginning_AsIsCorrect() {
		MovementCommand movementCommand = MovementCommand.valueOf("U");
		List<String> bridgeMocked = List.of("U", "U");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);

		BridgeMap bridgeMap1 = BridgeMap.constructedBy(crossingDecision, movementCommand); // first call
		BridgeMap bridgeMap2 = BridgeMap.constructedBy(crossingDecision, movementCommand); // second call

		List<String> actual1 = bridgeMap2.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap2.getUnderBridgeDescription();

		List<String> expected1 = List.of("[ O ", "| O ]");
		List<String> expected2 = List.of("[   ", "|   ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);

		BridgeMap.clearBridgeDescription();
	}

	@DisplayName("BridgeMap의 리스트 구조를 검증한다 : 2회 이상, 틀린 경우")
	@Test
	void verify_BridgeMap_CanDrawMap_FollowingBeginning_AsIsWrong() {
		MovementCommand movementCommand = MovementCommand.valueOf("D");
		List<String> bridgeMocked = List.of("U", "U");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);

		BridgeMap bridgeMap1 = BridgeMap.constructedBy(crossingDecision, movementCommand); // first call
		BridgeMap bridgeMap2 = BridgeMap.constructedBy(crossingDecision, movementCommand); // second call

		List<String> actual1 = bridgeMap2.getUpperBridgeDescription();
		List<String> actual2 = bridgeMap2.getUnderBridgeDescription();

		List<String> expected1 = List.of("[   ", "|   ]");
		List<String> expected2 = List.of("[ X ", "| X ]");

		assertThat(actual1).isEqualTo(expected1);
		assertThat(actual2).isEqualTo(expected2);

		BridgeMap.clearBridgeDescription();
	}
}

