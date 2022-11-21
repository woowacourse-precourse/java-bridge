package bridge.domain.game;

import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CrossingDecisionTest {

	@DisplayName("사용자 이동 선택 성공 여부를 판단하는 기능을 검증한다")
	@Test
	void verify_MovementDescription_CanFetchAssignedMark() {
		MovementCommand movementCommand = MovementCommand.valueOf("U");
		List<String> bridgeMocked = List.of("U", "U");

		Boolean actual = CrossingDecision.judgingBy(movementCommand, bridgeMocked).isCrossable();
		Boolean expected = true;

		assertThat(actual).isEqualTo(expected);
	}
}
