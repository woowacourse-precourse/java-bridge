package bridge.validation;

public class ReadMovingValidation {
    public void validateInputFormat(String movingCommand) {
        if ((! movingCommand.equals("D")) && (! movingCommand.equals("U"))) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸을 D 또는 U로 입력해주세요.");
        }
    }
}
