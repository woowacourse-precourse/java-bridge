package bridge.view;

public enum OutputViewString {
    START_MESSAGE("다리 건너기 게임을 시작합니다."),
    END_MESSAGE("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: %s\n총 시도한 횟수: %s");

    private String content;

    OutputViewString(String content){
        this.content = content;
    }

    public String print(){
        return content;
    }

    public String print(String whether, String number){
        return String.format(content, whether, number);
    }
}
