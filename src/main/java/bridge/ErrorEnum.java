package bridge;

public enum ErrorEnum {
    PREFIX("[ERROR] "),
    NUMERIC(" 숫자로 변환할 수 없는 입력입니다."),
    BRIDGE_VALUE("다리 길이는 " + InputView.MIN_BRIDGE + "부터" + InputView.MAX_BRIDGE + " 사이의 숫자여야 합니다."),
    UP_DOWN("입력은 U(위 칸)과 D(아래 칸) 중 하나로 입력해주세요.");

    private String message;

    ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
