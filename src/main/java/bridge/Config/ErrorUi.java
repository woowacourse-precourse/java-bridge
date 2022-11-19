package bridge.Config;

public enum ErrorUi {

    ERRORRANGE("[ERROR] 숫자 범위는 3 ~ 20 까지 입니다."),
    ERRORINPUT("[ERROR] 문자입력 U , D 만 가능합니다.");

    private String msg;

    private ErrorUi(String msg){
        this.msg = msg;
    }
}
