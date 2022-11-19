package enums;

public enum ResultMessage{
    RESULT_INTRO_TEXT("최종 게임 결과"),
    GAME_SUCCESS_OR_FAIL("게임 성공 여부: "),
    TOTAL_TRIAL_COUNT("총 시도한 횟수: ");

    private final String text;

    ResultMessage(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }


}
