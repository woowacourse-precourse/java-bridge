package bridge;

public class GameMessage {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요.";
    public static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final String ERROR_CHECKNUM = " 숫자를 입력해주세요.";
    public static final String ERROR_CHECKSIZE = " 3에서 20 사이의 숫자를 입력해주세요.";
    public static final String ERROR_CHECKMOVING = " U(위 칸), D(아래 칸)만 입력해주세요.";
    public static final String ERROR_CHECKEND = " R(재시작), Q(종료)만 입력해주세요.";

}
