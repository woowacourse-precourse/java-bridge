package bridge.Enums;

public enum OutputEnum {

    OUTPUT_RESULT("최종 게임 결과"),
    IS_SUCCESS("게임 성공 여부: "),
    TRY_COUNT("총 시도한 횟수: ");

    private final String outputMessage;
    OutputEnum(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public void getMessage() {
        System.out.println(outputMessage);
    }

    public void getMessage(String data) {
        System.out.println(outputMessage + data);
    }
}
