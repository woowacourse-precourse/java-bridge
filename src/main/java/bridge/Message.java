package bridge;

public class Message {
    static final String START_GAME = "다리 건너기 게임을 시작합니다\n";
    static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String SELECT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    static final String RETRY = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    static final String SUCCESS = "\n게임 성공 여부: 성공";
    static final String FAIL = "게임 성공 여부: 실패";
    static final String RESULT = "\n최종 게임 결과";
    static final String COUNT = "총 시도한 횟수: ";
    static final String INPUT_NUM_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의숫자여야합니다.";
    static final String INPUT_U_D_ERROR = "[ERROR] 이동할 칸은 위: U 또는 아래: D를 입력해주세요.";
    static final String INPUT_CORRECT_COMMAND = "[ERROR] 재시도: R, 종료: Q 중 하나를 입력해주세오.";

}
