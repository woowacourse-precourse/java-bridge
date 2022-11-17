package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class BridgeMakerTest {
	private BridgeMaker bridgeMaker;

	@BeforeEach
	void beforeEach(){
		bridgeMaker = new BridgeMaker(new BridgeOnlyZeroGenerator());
	}

	@DisplayName("다리 생성 값 테스트")
	@Test
	void makeBridgeValueTest() {
		List<String> bridge = bridgeMaker.makeBridge(5);
		Assertions.assertThat(bridge).containsOnly("D");
	}

	@DisplayName("다리 생성 길이 테스트")
	@ValueSource(ints = {3, 4, 5, 19, 20})
	@Test
	void makeBridgeSizeTest(int size) {
		List<String> bridge = bridgeMaker.makeBridge(size);
		Assertions.assertThat(bridge.size()).isEqualTo(size);
	}

	@DisplayName("다리 생성 길이 예외 테스트")
	@ValueSource(ints = {-1, 0, 1, 2, 21, 50})
	@Test
	void makeBridgeSizeExceptionTest(int size) {
		Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
				.isInstanceOf(IllegalArgumentException.class);
	}

	class BridgeOnlyZeroGenerator implements BridgeNumberGenerator {
		@Override
		public int generate() {
			return 0;
		}
	}
}