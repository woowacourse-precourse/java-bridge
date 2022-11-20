package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import repository.Bridge;

class BridgeTest {

	static Stream<List<String>> lists() {
		return Stream.of(
			List.of("U", "D", "R"),
			List.of("1", "U", "2"));
	}

	@DisplayName("다리를 검증한다.")
	@MethodSource("lists")
	@ParameterizedTest
	void validate(List<String> lists) {
		assertThatThrownBy(() -> {
			Bridge bridge = new Bridge(lists);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("다리를 생성한다.")
	@Test
	void make() {
		assertThat(new Bridge(List.of("U", "D", "U")).toBridgeDto().getPartOfBridge(3)).isEqualTo(List.of("U", "D", "U"));
	}

	@DisplayName("다리 길이를 반환한다.")
	@Test
	void length() {
		Bridge bridge;
		assertThat(new Bridge(List.of("U", "D", "U", "U", "U")).getBridgeSize()).isEqualTo(5);
	}
}