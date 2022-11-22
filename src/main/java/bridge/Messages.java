package bridge;

public enum Messages {
    START_MESSAGE(MessageType.PLAIN,  "다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_MESSAGE(MessageType.PLAIN, "다리의 길이를 입력해주세요"),
    INPUT_MOVE_MESSAGE(MessageType.PLAIN, "이동할 칸을 선택해주세요. (위: U, 아래: D"),
    RETRY_MESSAGE(MessageType.PLAIN,  "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q"),
    ERROR_INPUT_BRIDGE_MESSAGE(MessageType.ERROR, "다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_INPUT_MOVE_MESSAGE(MessageType.ERROR, "U(대문자), D(대문자)만 입력 가능합니다."),
    ERROR_RETRY_MESSAGE(MessageType.ERROR, "R(대문자), Q(대문자)만 입력 가능합니다.");

    private final String message;
    private final MessageType messageType;

    Messages(MessageType messageType, String message){
        this.message = message;
        this.messageType = messageType;
    }

    public String getMessage(){
        if(this.messageType == MessageType.ERROR){
            return "[ERROR]" + this.message;
        }
        return this.message;
    }

    public String getFormatMessage(Object... args){ return String.format(message, args);}
}
