package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputExceptionsTest {
	@DisplayName("유효한 입력일 경우 false를 반환") @Test public void 유효입력1() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("3");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("유효한 입력일 경우 false를 반환") @Test public void 유효입력2() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("20");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("유효한 입력일 경우 false를 반환") @Test public void 유효입력3() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("14");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 유효하지_않은_숫자인_경우1() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("333");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 유효하지_않은_숫자인_경우2() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("21");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 유효하지_않은_숫자인_경우3() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("2");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우1() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("가");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우2() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("A");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우3() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("3.4");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우4() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("-22");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우5() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("!@$%#");
		Assertions.assertThat(lengthFlag).isTrue();
	}
	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 글자인_경우6() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength(" ");
		Assertions.assertThat(lengthFlag).isTrue();
	}
	@DisplayName("유효한 입력이 아닐 경우 true를 반환") @Test public void 아무입력도_없는_경우() {
		boolean lengthFlag = UserInputExceptions.isNotValidLength("");
		Assertions.assertThat(lengthFlag).isTrue();
	}
}
