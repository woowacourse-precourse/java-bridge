package bridge.view.input;

public class RepeatInput<T> {
    public T read(Input<T> input) {
        while (true) {
            try {
                return input.read();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
