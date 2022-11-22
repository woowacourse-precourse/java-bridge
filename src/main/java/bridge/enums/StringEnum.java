package bridge.enums;

public enum StringEnum {
    UP("U"),
    DOWN("D"),
    QUIT("Q"),
    RESTART("R"),
    GAME_START("다리 건너기 게임을 시작합니다."),
    ASK_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    ASK_MOVING("이동할 칸을 선택해주세요. (위 : "+UP+", 아래 : "+DOWN+")"),
    ASK_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: "+RESTART+", 종료 : "+QUIT+")"),
    GAME_FINAL("최종 게임 결과"),
    SUCCESS_GAME("게임 성공 여부: "),
    CHALLENGE("총 시도한 횟수: ");
    private final String key;
    private StringEnum(String key){
        this.key=key;
    }
    public String key(){
        return this.key;
    }
}
