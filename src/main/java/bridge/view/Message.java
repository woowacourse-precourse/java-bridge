package bridge.view;

public enum Message {

	ERROR("[ERROR] "),
	INPUT_NOT_NUMBER("입력된 값이 숫자가 아닙니다."),
	INPUT_OUT_OF_RANGE("입력된 값이 범위를 벗어납니다."),
	INPUT_NOT_MOVE_COMMAND("입력된 값이 U나 D가 아닙니다."),
	INPUT_NOT_GAME_COMMAND("입력된 값이 R나 Q가 아닙니다."),
	START_GAME("다리 건너기 게임을 시작합니다.\n\n"),
	INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요.\n"),
	INPUT_MOVE_COMMAND("이동할 칸을 선택해주세요. (위: U, 아래: D)\n"),
	INPUT_GAME_COMMAND("게임을 다시 시도할지 여부를 입력해주세요, (재시도 : R, 종료 : Q)\n"),
	FINAL_GAME_RESULT("최종 게임 결과\n"),
	WHETHER_GAME_SUCCESSFUL("게임 성공 여부: "),
	TOTAL_ATTEMPTS("총 시도한 횟수: ");

	private final String message;

	Message(String message) {
		this.message = message;
	}

	public static String getErrorMessage(Message message) {
		return ERROR.message + message.message;
	}

	public static void printMessage(Message message) {
		System.out.print(message.message);
	}

	public static void printFinalMessage(boolean isSuccess, int gameCount) {
		if (isSuccess) {
			System.out.println(WHETHER_GAME_SUCCESSFUL.message + "성공");
			System.out.println(TOTAL_ATTEMPTS.message + gameCount);
			return;
		}
		System.out.println(WHETHER_GAME_SUCCESSFUL.message + "실패");
		System.out.println(TOTAL_ATTEMPTS.message + gameCount);
	}

}
