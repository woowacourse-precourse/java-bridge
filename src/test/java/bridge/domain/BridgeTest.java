package bridge.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

class BridgeTest {

	@ParameterizedTest
	@ValueSource(ints = {2, 30, 0, 22, 1})
	@DisplayName("다리 길이가 맞지 않을 시의 예외 검증")
	void wrongRangeTest(int size) {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		List<String> blocks = bridgeMaker.makeBridge(size);

		assertThrows(IllegalArgumentException.class, () -> new Bridge(blocks));
	}
}
