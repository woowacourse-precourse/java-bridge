package bridge.utils.constant;

public enum ExceptionPhrase {

    ERROR("[ERROR] "),
    INVALID_INPUT_NOT_Q_OR_R("Q나 R을 입력해주세요"),
    INVALID_INPUT_NOT_RANGE_IN_THREE_TO_TWENTY("3에서 20 사이의 숫자를 입력해주세요"),
    INVALID_INPUT_NOT_NUMBER("숫자(자연수)를 입력해주세요"),
    INVALID_INPUT_NOT_U_OR_D("U나 D를 입력해주세요");



    private final String phrase;

    ExceptionPhrase(String phrase) {
        this.phrase = phrase;
    }

    public String getPhrase() {
        return phrase;
    }
}

