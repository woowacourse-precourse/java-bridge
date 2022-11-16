package view;

import static org.assertj.core.api.Assertions.*;

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
				assertThat(resultBridgeSize).isEqualTo(expectedBridgeSize);
			}
		}
	}

	@Nested
	@DisplayName("예외상황 테스트 클래스")
	class FailTest {

		@Test
		@DisplayName("다리 길이 영어를 입력하는 경우 테스트")
		void inputBridgeSizeEnglish() {
			// given
			List<String> bridgeSizes = List.of("3a", "2z0", "9e", "s10", "ra");

			for (String bridgeSize : bridgeSizes) {
				// when, then
				readLine(bridgeSize);
				assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("다리 길이 한글을 입력하는 경우 테스트")
		void inputBridgeSizeKorean() {
			// given
			List<String> bridgeSizes = List.of("ㄱ", "1ㅂ", "2ㅃ", "1ㄲ", "ㅏ2", "ㅎ3", "퉯1", "개", "댤ㅇㅣ얽2", "다리길이");

			for (String bridgeSize : bridgeSizes) {
				// when, then
				readLine(bridgeSize);
				assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("다리 길이 특수문자를 입력하는 경우 테스트")
		void inputBridgeSizeSpecialCharacter() {
			// given
			List<String> bridgeSizes = List.of("!", "1%", "2/", "/3", ")%", "2");

			for (String bridgeSize : bridgeSizes) {
				// when, then
				readLine(bridgeSize);
				assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("다리 길이 공백을 입력하는 경우 테스트")
		void inputBridgeSizeSpaceBar() {
			// given
			List<String> bridgeSizes = List.of("1 ", " 9", "2 0", "1 2", " ", "  ");

			for (String bridgeSize : bridgeSizes) {
				// when, then
				readLine(bridgeSize);
				assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
			}
		}

		@Test
		@DisplayName("다리 길이 3~20을 벗어나는 입력 경우 테스트")
		void inputBridgeSizeOutOfRange() {
			// given
			List<String> bridgeSizes = List.of("2", "21", "1", "111", "22", "23");

			for (String bridgeSize : bridgeSizes) {
				// when, then
				readLine(bridgeSize);
				assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
			}
		}
	}

	private void readLine(String bridgeSize) {
		InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
		System.setIn(in);
	}
}
