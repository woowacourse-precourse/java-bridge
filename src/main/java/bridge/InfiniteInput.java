package bridge;

import java.util.function.Supplier;

public class InfiniteInput<T> {
    private final T defaultValue;

    public InfiniteInput(T defaultValue){
        this.defaultValue = defaultValue;
    }

    public T getInput(Supplier<T> inputSupplier, OutputView outputView){
        // TODO: 사용자가 알맞은 입력을 할 때까지 계속해서 입력
        return null;
    }
}
