package bridge;

public interface ExceptionTemplate {

    String ERROR = "[ERROR]";

    default Object check() {
        while (true) {
            try {
                return input();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR + e.getMessage());
            }
        }
    }

    Object input() throws IllegalArgumentException;
}
