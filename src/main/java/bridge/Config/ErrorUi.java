package bridge.Config;

public enum ErrorUi {

    ERRORRANGE("[ERROR] 숫자 범위는 3 ~ 20 까지 입니다."),
    ERRORMOVE("[ERROR] 문자입력 U , D 만 가능합니다."),
    ERRORINPUT("[ERROR] 숫자 입력만 가능 합니다 (범위 3~20"),
    ERRORRETRY("[ERROR] 문자입력 R , Q 만 가능합니다.");

    private String msg;

    public String getMsg(){
        return this.msg;
    }

    private ErrorUi(String msg){
        this.msg = msg;
    }
}
