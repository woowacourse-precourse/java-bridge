package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

	static Stream<List<String>> lists() {
		return Stream.of(
			List.of("U", "D", "R"),
			List.of("1", "U", "D"),
			List.of("", "U", "D"),
			List.of(" ", "U", "D"),
			List.of("U", "D"));
	}

	@DisplayName("다리를 검증한다.")
	//given
	@MethodSource("lists")
	@ParameterizedTest
	void validate(List<String> lists) {
		//when, then
		assertThatThrownBy(() -> {
			Bridge bridge = new Bridge(lists);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("다리를 생성한다.")
	@Test
	void make() {
		//given, when, then
		assertThat(new Bridge(List.of("U", "D", "U")).getBridge()).isEqualTo(
			List.of("U", "D", "U"));
	}
}