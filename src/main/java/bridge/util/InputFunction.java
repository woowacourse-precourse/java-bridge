package bridge.util;

@FunctionalInterface
public interface InputFunction<T> {

    T read();
}
