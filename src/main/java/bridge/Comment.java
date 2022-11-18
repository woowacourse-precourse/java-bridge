package bridge;

public enum Comment {
    START_GAME("다리 건너기 게임을 시작합니다."),
    INPUT_SIZE_OF_BRIDGE("다리의 길이를 입력해주세요."),
    INPUT_MOVEMENT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    INPUT_GAME_COMMEND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT("최종 게임 결과"),
    WIN_OR_LOSE("게임 성공 여부: "),
    TOTAL_ATTEMPT("총 시도한 횟수: ");

    final String line;
    Comment(String line){
        this.line = line;
    }
}
