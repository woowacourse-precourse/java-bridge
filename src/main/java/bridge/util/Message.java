package bridge.util;

public class Message {
	private Message() {
	}

	public static final String ERROR = "[ERROR] ";
	public static final String ERROR_NUMBERS_ONLY = ERROR + "숫자만 입력해주세요.";
	public static final String ERROR_RANGE = ERROR + "2 이상 20 이하의 숫자를 입력해주세요.";
	public static final String ERROR_ONE_CHARACTER = ERROR + "한 글자만 입력해주세요.";
	public static final String ERROR_ENGLISH_ONLY = ERROR + "영어만 입력해주세요.";
	public static final String ERROR_UPPERCASE_ONLY = ERROR + "대문자만 입력해주세요.";
	public static final String ERROR_UD_ONLY = ERROR + "U와 D만 입력해주세요.";
	public static final String ERROR_RQ_ONLY = ERROR + "R과 Q만 입력해주세요.";

	public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
	public static final String INPUT_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public static final String INPUT_RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

	public static final String OUTPUT_START_GAME = "다리 건너기 게임을 시작합니다.";
	public static final String OUTPUT_GAME_RESULT = "최종 게임 결과";
	public static final String OUTPUT_GAME_REPORT = "게임 성공 여부: ";
	public static final String SUCCESS_MESSAGE = "성공";
	public static final String FAIL_MESSAGE = "실패";
	public static final String OUTPUT_TOTAL_TRY_COUNT = "총 시도한 횟수: ";
}
