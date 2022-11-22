package bridge;

import java.util.function.Supplier;

public class InfiniteInput<T> {
    private final T defaultValue;

    public InfiniteInput(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    public T getInput(Supplier<T> inputSupplier, OutputView outputView) {
        T value = defaultValue;
        do {
            try {
                value = inputSupplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (value.equals(defaultValue));
        return value;
    }
}
