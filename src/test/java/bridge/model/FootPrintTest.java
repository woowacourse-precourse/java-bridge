package bridge.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FootPrintTest {
	@DisplayName("층수와 정답 여부를 입력하면 footPrints를 리턴한다.")
	@ParameterizedTest
	@MethodSource("parametersProvider")
	void makeFootPrintsTest(int stairs, Boolean isRight, List<String> list) {
		assertEquals(FootPrint.makeFootPrints(stairs, isRight), list);
	}

	static Stream<Arguments> parametersProvider() {
		return Stream.of(
			Arguments.arguments(0, true, List.of(FootPrint.RIGHT.getFootPrint(), FootPrint.BLANK.getFootPrint())),
			Arguments.arguments(1, true, List.of(FootPrint.BLANK.getFootPrint(), FootPrint.RIGHT.getFootPrint())),
			Arguments.arguments(0, false, List.of(FootPrint.WRONG.getFootPrint(), FootPrint.BLANK.getFootPrint())),
			Arguments.arguments(1, false, List.of(FootPrint.BLANK.getFootPrint(), FootPrint.WRONG.getFootPrint())));
	}
}
