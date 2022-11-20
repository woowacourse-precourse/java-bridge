package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeRandomNumberGeneratorTest {

	@DisplayName("makeBridge는 주어진 size만큼의 다리 발판 List를 반환한다")
	@Test
	void makeBridge() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> bridgeBoards = bridgeMaker.makeBridge(3);

		assertThat(bridgeBoards).hasSize(3);
	}
}
