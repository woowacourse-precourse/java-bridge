package bridge;

public class Validation {

    public boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]문자가 아닌 숫자를 입력해주세요.");
        }

        return true;
    }

    public void validateInputPosition(String position) {
        if (!position.equals("U") && !position.equals("D")) {
            throw new IllegalArgumentException("[ERROR]위로 가려면 U, 아래로 가려면 D를 입력해주세요.");
        }
    }

    public void validateInputRetry(String retryCommand) {
        if (!retryCommand.equals("R") && !retryCommand.equals("Q")) {
            throw new IllegalArgumentException("[ERROR]재시작은 R, 종료는 Q를 입력해주세요.");
        }
    }
}
