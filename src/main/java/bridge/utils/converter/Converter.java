package bridge.utils.converter;

public interface Converter<Integer, T> {

    T toUpOrDown(Integer input);

}
