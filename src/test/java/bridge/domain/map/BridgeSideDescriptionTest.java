package bridge.domain.map;

import bridge.domain.player.MovementCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeSideDescriptionTest {

	@DisplayName("다리의 Map 요소인 리스트를 enum 클래스로서 제대로 소유하며 리턴하는지 검증한다")
	@Test
	void verify_BridgeSideDescription_CanFetchList() {
		BridgeSideDescription bridgeSideDescription = BridgeSideDescription.of(MovementCommand.valueOf("U"));
		List<String> actual1 = bridgeSideDescription.getSide();
		List<String> actual2 = bridgeSideDescription.getOtherSide();

		List<String> expected1 = BridgeMap.upperBridgeDescription;
		List<String> expected2 = BridgeMap.underBridgeDescription;

		assertThat(actual1).isSameAs(expected1);
		assertThat(actual2).isSameAs(expected2);
	}
}
