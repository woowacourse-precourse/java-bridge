package view;

import static org.assertj.core.api.Assertions.*;
import static view.InputViewConstants.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import validator.BridgeSizeInputValidator;
import validator.GameCommandInputValidator;
import validator.MovingInputValidator;

public class InputViewTest {

	InputView inputView = new InputView();
	BridgeSizeInputValidator bridgeSizeValidator = new BridgeSizeInputValidator();
	MovingInputValidator movingInputValidator = new MovingInputValidator();
	GameCommandInputValidator gameCommandInputValidator = new GameCommandInputValidator();

	@Nested
	@DisplayName("다리 길이 입력 기능 테스트 클래스")
	class ReadBridgeSizeTest {

		@Nested
		@DisplayName("성공 테스트 클래스")
		class SuccessTest {

			@Test
			@DisplayName("다리 길이 3에서 20을 입력하는 경우 테스트")
			void inputBridgeSizeThreeToTwenty() {
				// given
				List<String> bridgeSizes = List.of("3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
						"15", "16", "17", "18", "19", "20");

				for (String bridgeSize : bridgeSizes) {
					// when
					int expectedBridgeSize = Integer.parseInt(bridgeSize);
					readLine(bridgeSize);
					int resultBridgeSize = Integer.parseInt(bridgeSizeValidator.validateBridgeSize(bridgeSize));

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
//					readLine(bridgeSize);
					assertThatThrownBy(() -> bridgeSizeValidator.validateBridgeSize(bridgeSize))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining(ERROR_MESSAGE_NON_NUMERIC);

//					assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("다리 길이 한글을 입력하는 경우 테스트")
			void inputBridgeSizeKorean() {
				// given
				List<String> bridgeSizes = List.of("ㄱ", "1ㅂ", "2ㅃ", "1ㄲ", "ㅏ2", "ㅎ3", "퉯1", "개", "댤ㅇㅣ얽2", "다리길이");

				for (String bridgeSize : bridgeSizes) {
					// when, then
//					readLine(bridgeSize);
					assertThatThrownBy(() -> bridgeSizeValidator.validateBridgeSize(bridgeSize))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining(ERROR_MESSAGE_NON_NUMERIC);

//					assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("다리 길이 특수문자를 입력하는 경우 테스트")
			void inputBridgeSizeSpecialCharacter() {
				// given
				List<String> bridgeSizes = List.of("!", "1%", "2/", "/3", ")%", "-");

				for (String bridgeSize : bridgeSizes) {
					// when, then
					readLine(bridgeSize);
					assertThatThrownBy(() -> bridgeSizeValidator.validateBridgeSize(bridgeSize))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining(ERROR_MESSAGE_NON_NUMERIC);

					/** 잘못된 테스트 진행 방식 */
//					assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
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
					assertThatThrownBy(() -> bridgeSizeValidator.validateBridgeSize(bridgeSize))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining(ERROR_MESSAGE_NON_NUMERIC);

//					assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("다리 길이 3~20을 벗어나는 입력 경우 테스트")
			void inputBridgeSizeOutOfRange() {
				// given
				List<String> bridgeSizes = List.of("2", "22", "1", "111", "22", "23");

				for (String bridgeSize : bridgeSizes) {
					// when, then
					readLine(bridgeSize);
					assertThatThrownBy(() -> bridgeSizeValidator.validateBridgeSize(bridgeSize))
							.isInstanceOf(IllegalArgumentException.class)
							.hasMessageContaining(ERROR_MESSAGE_OUT_OF_RANGE);

//					assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class);
				}
			}
		}
	}

	@Nested
	@DisplayName("이동할 칸 입력 기능 테스트")
	class ReadMovingTest {

		@Nested
		@DisplayName("성공 테스트 클래스")
		class SuccessTest {

			@Test
			@DisplayName("이동할 칸 U 입력하는 경우 테스트")
			void inputMovingU() {
				// given
				String moving = "U";

				// when
				readLine(moving);
				String expectedMoving = "U";

				// then
				assertThat(inputView.readMoving()).isEqualTo(expectedMoving);
			}

			@Test
			@DisplayName("이동할 칸 D 입력하는 경우 테스트")
			void inputMovingD() {
				// given
				String moving = "D";

				// when
				readLine(moving);
				String expectedMoving = "D";

				// then
				assertThat(inputView.readMoving()).isEqualTo(expectedMoving);
			}
		}

		@Nested
		@DisplayName("에외상황 테스트 클래스")
		class FailTest {

			@Test
			@DisplayName("이동할 칸 U와 D를 제외한 입력 경우 테스트")
			void inputMovingWrong() {
				// given
				List<String> movings = List.of("ㄱ", "ㅃㅉㄸ머ㅏ", "1234", "1", "9999", "!ㄲㅇ", "!U", "D2", "UU", "DD", "UD",
						"DU", "D!", ".D", "U(", "\\");

				for (String moving : movings) {
					// when, then
//					readLine(moving);
					assertThatThrownBy(() -> movingInputValidator.validateMoving(moving))
							.isInstanceOf(IllegalArgumentException.class);
				}
			}
		}
	}

	@Nested
	@DisplayName("재시작 여부 입력 기능 테스트")
	class ReadGameCommandTest {

		@Nested
		@DisplayName("성공 테스트 클래스")
		class SuccessTest {

			@Test
			@DisplayName("재시작 여부 R 또는 Q를 입력하는 경우 테스트")
			void inputGameCommandCorrect() {
				// given
				List<String> gameCommands = List.of("R", "Q", "R", "Q", "Q");

				for (String gameCommand : gameCommands) {
					// when
					readLine(gameCommand);
					String expectedGameCommand = inputView.readGameCommand();

					// then
					assertThat(gameCommand).isEqualTo(expectedGameCommand);
				}
			}
		}

		@Nested
		@DisplayName("에외상황 테스트 클래스")
		class FailTest {

			@Test
			@DisplayName("재시작 여부 소문자로 입력한 경우 테스트")
			void inputGameCommandLowerCase() {
				// given
				List<String> gameCommands = List.of("r", "q", "a", "b", "c", "rQ", "Rq", "qqq", "qR");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("재시작 여부 한글 입력 경우 테스트")
			void inputGameCommandKorean() {
				// given
				List<String> gameCommands = List.of("ㄱ", "ㅎ", "ㅃ", "ㅓ", "ㅏ", "Rㄱ", "Qㅓ", "Rㅎ", "한글");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("재시작 여부 숫자 입력한 경우 테스트")
			void inputGameCommandNumeric() {
				// given
				List<String> gameCommands = List.of("1", "123", "31", "1R", "R1", "Q1", "1Q", "R1Q");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("재시작 여부 특수문자 입력한 경우 테스트")
			void inputGameCommandSpecialCharacter() {
				// given
				List<String> gameCommands = List.of("R!", "!R", "_R", "Q%", "/Q", "\\", "RQQQQ!#$");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("재시작 여부 중복 입력 경우 테스트")
			void inputGameCommandDuplicate() {
				// given
				List<String> gameCommands = List.of("RR", "QQ", "RQ", "QR");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}

			@Test
			@DisplayName("재시작 여부 공백 입력 경우 테스트")
			void inputGameCommandSpaceBar() {
				// given
				List<String> gameCommands = List.of("R ", "Q ", " R", " Q", " ", "   ", "R Q", " Q ");

				for (String gameCommand : gameCommands) {
					// when, then
//					readLine(gameCommand);
					assertThatThrownBy(() -> gameCommandInputValidator.validateGameCommand(gameCommand)).isInstanceOf(IllegalArgumentException.class);
				}
			}
		}
	}

	private void readLine(String bridgeSize) {
		InputStream in = new ByteArrayInputStream(bridgeSize.getBytes());
		System.setIn(in);
	}
}
