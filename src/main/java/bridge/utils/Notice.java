package bridge;

public enum Notice {
	ERROR("[ERROR] 다시 입력해주세요."),
	START("다리 건너기 게임을 시작합니다."),
	RETRY("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
	FINAL_RESULT("최종 게임 결과\n"),
	WHETHER("\n게임 성공 여부: "),
	SUCCESS("성공"),
	FAIL("실패"),
	COUNT("총 시도한 횟수: "),
	CHOICE_SIZE("다리의 길이를 입력해주세요."),
	CHOICE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)");
	private final String message;

	Notice(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
