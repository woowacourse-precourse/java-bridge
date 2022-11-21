package bridge.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import bridge.model.validation.Stairs;

class FootPrintTest {
	@DisplayName("층수와 정답 여부를 입력하면 footPrint 리스트를 리턴한다.")
	@ParameterizedTest
	@MethodSource("parametersProvider")
	void makeFootPrintsTest(int stairs, Boolean isRight, List<String> list) {
		assertEquals(FootPrint.makeFootPrints(stairs, isRight), list);
	}

	static Stream<Arguments> parametersProvider() {
		return Stream.of(
			Arguments.arguments(Stairs.DOWN.getNumber(), true,
				List.of(FootPrint.RIGHT.getFootPrint(), FootPrint.BLANK.getFootPrint())),
			Arguments.arguments(Stairs.UP.getNumber(), true,
				List.of(FootPrint.BLANK.getFootPrint(), FootPrint.RIGHT.getFootPrint())),
			Arguments.arguments(Stairs.DOWN.getNumber(), false,
				List.of(FootPrint.WRONG.getFootPrint(), FootPrint.BLANK.getFootPrint())),
			Arguments.arguments(Stairs.UP.getNumber(), false,
				List.of(FootPrint.BLANK.getFootPrint(), FootPrint.WRONG.getFootPrint())));
	}
}
