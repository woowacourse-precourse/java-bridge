package bridge.controller;

@FunctionalInterface
public interface TryCatchCallback<T> {
    public T run();
}
