package view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewTest {

	InputView inputView = new InputView();

	@Nested
	@DisplayName("성공 테스트 클래스")
	class SuccessTest {

		@Test
		@DisplayName("다리 길이 3에서 20을 입력하는 경우 테스트")
		void inputBridgeSizeThreeToTwenty() {
			// given
			List<String> bridgeSizes = List.of("3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
					"16", "17", "18", "19", "20");

			for (String bridgeSize : bridgeSizes) {

				// when
				int expectedBridgeSize = Integer.parseInt(bridgeSize);
				readLine(bridgeSize);
				int resultBridgeSize = inputView.readBridgeSize();

				// then
				Assertions.assertThat(resultBridgeSize).isEqualTo(expectedBridgeSize);
			}
		}
	}

	@Nested
	@DisplayName("예외상황 테스트 클래스")
	class FailTest {

	}

	private void readLine(String bridgeSize) {
		InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
		System.setIn(in);
	}
}
