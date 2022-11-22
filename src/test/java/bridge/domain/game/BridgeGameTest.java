package bridge.domain.game;

import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.maker.BridgeMaker;
import bridge.domain.maker.BridgeRandomNumberGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

	@DisplayName("다리만들기 테스트")
	@ParameterizedTest
	@CsvSource(value = {"3:3","6:6"},delimiterString = ":")
	void 입력값size에맞는_다리길이가_나와야합니다(int size,int expected) {
		BridgeGame bridgeGame = new BridgeGame();
		Assertions.assertThat(bridgeGame.makeBridge(size).size()).isEqualTo(expected);
	}

	@DisplayName("이동 테스트")
	@ParameterizedTest
	@MethodSource("generateData")
	void 다리이동_테스트(List<String> bridges,List<String> move,int index,boolean expected){
		BridgeGame bridgeGame = new BridgeGame();
		Assertions.assertThat(bridgeGame.move(bridges,move,index)).isEqualTo(expected);
	}
	static Stream<Arguments> generateData() {
		return Stream.of(
				Arguments.of(Arrays.asList("U", "D", "U"), Arrays.asList("U"), 0,true),
				Arguments.of(Arrays.asList("U", "D", "U"), Arrays.asList("U", "D"), 1,true),
				Arguments.of(Arrays.asList("U", "D", "U"), Arrays.asList("D"), 0,false),
				Arguments.of(Arrays.asList("U", "D", "U"), Arrays.asList("U", "U"), 1,false)
		);
	}

	@DisplayName("재시작 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = {"R:0","Q:2147483647"},delimiterString = ":")
	void 재시작_기능_테스트(String command,int expected){
		BridgeGame bridgeGame = new BridgeGame();
		Assertions.assertThat(bridgeGame.retry(command)).isEqualTo(expected);
	}

}