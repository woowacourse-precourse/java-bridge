package bridge;

public enum Message {
    EMPTY(" "),
    START("다리 건너기 게임을 시작합니다."),
    SIZE("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    RESULT("최종 게임 결과"),
    SUCCESS("게임 성공 여부: "),
    TRY("총 시도한 횟수: "),
    BRIDGE_START("[ "),
    BRIDGE_MIDDLE(" | "),
    BRIDGE_END(" ]"),
    ERROR_HEAD("[ERROR] "),
    ERROR_SIZE("다리 길이는 3부터 20 사이의 정수여야 합니다."),
    ERROR_MOVE( "이동 가능한 방향은 U 또는 D여야 합니다."),
    ERROR_COMMAND("입력 값은 R(Restart) 또는 Q(Quit) 여야 합니다.");


    private final String OF;

    public String OF(){
        return OF;
    }
    Message(String message){
        OF = message;
    }
}
