package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserInputExceptionsTest {
	@DisplayName("다리길이 : 최소경계값") @Test public void 유효입력1() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("3");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("다리길이 : 최대경계값") @Test public void 유효입력2() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("20");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("다리길이 : 범위 내의 숫자") @Test public void 유효입력3() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("14");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("다리길이 : 범위 외의 수(세자리 수 입력)") @Test public void 유효하지_않은_숫자인_경우1() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("333");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 범위 외의 수(두자리 수 입력)") @Test public void 유효하지_않은_숫자인_경우2() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("21");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 범위 외의 수(한자리 수 입력)") @Test public void 유효하지_않은_숫자인_경우3() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("2");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 한글입력") @Test public void 글자인_경우1() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("가");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 영어입력") @Test public void 글자인_경우2() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("A");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 소수점 입력") @Test public void 글자인_경우3() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("3.4");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 음수 입력") @Test public void 글자인_경우4() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("-22");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 특수문자 입력") @Test public void 글자인_경우5() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("!@$%#");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 스페이스바 입력") @Test public void 글자인_경우6() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize(" ");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("다리길이 : 아무값도 입력하지 않음") @Test public void 아무입력도_없는_경우() {
		boolean lengthFlag = UserInputExceptions.isNotValidSize("");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : U") @Test public void 유효입력_U() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("U");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("이동 : D") @Test public void 유효입력_D() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("D");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("이동 : 소문자열 입력") @Test public void 잘못된입력1() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("geriuw");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 대문자열 입력") @Test public void 잘못된입력2() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("REIHW");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 한글입력") @Test public void 잘못된입력3() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("무야호");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 특수문자") @Test public void 잘못된입력4() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("!#@$%^");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 스페이스바") @Test public void 잘못된입력5() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("      ");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 아무것도 입력 안함") @Test public void 잘못된입력6() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 한글자만 다르게") @Test public void 잘못된입력7() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("d");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("이동 : 한글자만 다르게") @Test public void 잘못된입력8() {
		boolean lengthFlag = UserInputExceptions.isNotValidMove("u");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리 명령 : 종료 Q") @Test public void 유효입력_Q() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("Q");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("마무리 명령 : 종료 R") @Test public void 유효입력_R() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("R");
		Assertions.assertThat(lengthFlag).isFalse();
	}

	@DisplayName("마무리 명령 : 소문자열 입력") @Test public void 잘못된마무리명령1() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("geriuw");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리 명령 : 대문자열 입력") @Test public void 잘못된마무리명령2() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("REIHW");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리 명령 : 한글입력") @Test public void 잘못된마무리명령3() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("무야호");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리 명령 : 특수문자") @Test public void 잘못된마무리명령4() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("!#@$%^");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리명령 : 스페이스바") @Test public void 잘못된마무리명령5() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("      ");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리명령 : 아무것도 입력 안함") @Test public void 잘못된마무리명령6() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리명령 : 한글자 소문자로 q") @Test public void 잘못된마무리명령7() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("q");
		Assertions.assertThat(lengthFlag).isTrue();
	}

	@DisplayName("마무리명령 : 한글자 소문자로 r") @Test public void 잘못된마무리명령8() {
		boolean lengthFlag = UserInputExceptions.isNotValidEndCommand("r");
		Assertions.assertThat(lengthFlag).isTrue();
	}
}
