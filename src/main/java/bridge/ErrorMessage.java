package bridge;

public class ErrorMessage {
	public enum errorMessage {
		ONLY_INPUT_INTEGER("Integer 값만 입력할 수 있습니다."),
		ONLY_INPUT_BETWEEN_3_20("3~20 범위의 Integer 값만 입력할 수 있습니다."),
		ONLY_INPUT_U_AND_D("U(위) 또는 D(아래)값만 입력 할 수 있습니다."),
		ONLY_INPUT_R_AND_Q("R(재시작) 또는 Q(종료)값만 입력 할 수 있습니다.");
		private final String description;

		errorMessage(String description) {
			this.description = description;
		}

		public String getValue() {
			return "[ERROR]" + description;
		}
	}
}
