package bridge.domain.map;

import bridge.domain.game.CrossingDecision;
import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MovementDescriptionTest {

	@DisplayName("이동 선택에 대한 결과 출력 요소인 OX에 대해서 enum 클래스로서 제대로 소유하며 리턴하는지 검증한다")
	@Test
	void verify_MovementDescription_CanFetchAssignedMark() {
		MovementCommand movementCommand = MovementCommand.valueOf("U");
		List<String> bridgeMocked = List.of("U", "U");
		CrossingDecision crossingDecision = CrossingDecision.judgingBy(movementCommand, bridgeMocked);
		MovementDescription movementDescription = MovementDescription.of(crossingDecision);

		String actual = movementDescription.getMark();
		String expected = "O";

		assertThat(actual).isEqualTo(expected);
	}
}
