package bridge;

public interface ExceptionTemplate {

    default Object check() {
        while (true) {
            try {
                return input();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    Object input() throws IllegalArgumentException;
}
