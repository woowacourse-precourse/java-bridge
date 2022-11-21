package bridge.validation;

public class ReadGameCommandValidation {
    public void validateInputFormat(String gameCommand) {
        if ((! gameCommand.equals("R")) && (! gameCommand.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시작, 종료 여부를 R 또는 Q로 입력해주세요.");
        }
    }
}
