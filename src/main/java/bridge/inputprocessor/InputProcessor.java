package bridge.inputprocessor;

import java.util.function.Supplier;

public class InputProcessor<R> {

    private final Supplier<R> processor;

    public InputProcessor(Supplier<R> processor) {
        this.processor = processor;
    }

    public R process() {
        while (true) {
            try {
                return processor.get();
            } catch (IllegalArgumentException ignore) {
            }
        }
    }
}
