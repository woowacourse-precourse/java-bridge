package bridge;

public enum MessageCase {
    START("다리 건너기 게임을 시작합니다."),
    BRIDESIZE("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    GAMESUCCESS("게임 성공 여부: 성공"),
    GAMEFAILED("게임 성공 여부: 실패"),
    GAMETRY("총 시도한 횟수: "),
    LEFTBRACKET("["),
    RIGHTBRACKET("]"),
    DIVISION("|");

    MessageCase(String message){
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
