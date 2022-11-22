package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeMaker 클래스")
class BridgeMakerTest {

	@Nested
	@DisplayName("makeBridge 메소드는")
	class Describe_makeBridge {
		int size = 1;

		@Nested
		@DisplayName("랜덤 숫자 생성기가 생성한 임의의 숫자가 0이라면")
		class Context_BridgeRandomNumberGenerator_create_number_zero {
			bridge.BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new bridge.BridgeRandomNumberGenerator() {
				@Override
				public int generate() {
					return Randoms.pickNumberInRange(0, 0);
				}
			};

			@Test
			@DisplayName("해당 다리의 칸에 D를 생성한다.")
			void it_create_list_includes_D() {
				BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
				List<String> bridge = bridgeMaker.makeBridge(size);
				List<String> expected = new ArrayList<>(Arrays.asList("D"));
				assertThat(bridge).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("랜덤 숫자 생성기가 생성한 임의의 숫자가 1이라면")
		class Context_BridgeRandomNumberGenerator_create_number_one {
			bridge.BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new bridge.BridgeRandomNumberGenerator() {
				@Override
				public int generate() {
					return Randoms.pickNumberInRange(1, 1);
				}
			};

			@Test
			@DisplayName("해당 다리의 칸에 U를 생성한다.")
			void it_create_list_includes_U() {
				BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
				List<String> bridge = bridgeMaker.makeBridge(size);
				List<String> expected = new ArrayList<>(Arrays.asList("U"));
				assertThat(bridge).isEqualTo(expected);
			}
		}

		@Nested
		@DisplayName("랜덤 숫자 생성기가 생성한 임의의 숫자가 0,1이 아니라면")
		class Context_BridgeRandomNumberGenerator_create_number_is_not_zero_or_one {

			bridge.BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new bridge.BridgeRandomNumberGenerator() {
				@Override
				public int generate() {
					return Randoms.pickNumberInRange(2, 100);
				}
			};

			@Test
			@DisplayName("예외를 발생시킨다.")
			@RepeatedTest(100)
			void it_returns_illegal_argument_exception() {
				BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
				assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
					.isInstanceOf(IllegalArgumentException.class);
			}
		}
	}
}
