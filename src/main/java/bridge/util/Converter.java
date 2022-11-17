package bridge.util;

@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);

}
