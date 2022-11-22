package bridge.view;

public class InputValidator {

    public void validateSize(String input) {
        int size = toNumber(input);
        validateRangeOfSize(size, 3, 20);
    }

    private int toNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            System.out.println("[ERROR] 숫자를 입력하세요.");
            throw exception;
        }
    }

    private void validateRangeOfSize(int size, int min, int max) throws IllegalArgumentException {
        if (size < min || max < size) {
            System.out.printf("[ERROR] %d 이상 %d 이하의 자연수를 입력하세요.\n", min, max);
            throw new IllegalArgumentException();
        }
    }

    public void validateMoving(String input) throws IllegalArgumentException {
        if (input.equals("U") || input.equals("D")) {
            return;
        }
        System.out.println("[ERROR] U 또는 D를 입력하세요.");
        throw new IllegalArgumentException();
    }

    public void validateGameCommand(String input) throws IllegalArgumentException {
        if (input.equals("R") || input.equals("Q")) {
            return;
        }
        System.out.println("[ERROR] R 또는 Q를 입력하세요.");
        throw new IllegalArgumentException();
    }
}
