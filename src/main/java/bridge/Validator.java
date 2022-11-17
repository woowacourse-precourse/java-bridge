package bridge;

public class Validator {

    public void checkSize(String sizeName) {
        try {
            int size = Integer.parseInt(sizeName);

            if (20 < size || size < 3) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    ExceptionMessage.incorrectSize.getMessage());
        }
    }
}
