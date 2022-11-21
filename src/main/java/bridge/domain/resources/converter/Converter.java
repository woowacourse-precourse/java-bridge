package bridge.domain.resources.converter;

public interface Converter<Integer, T> {

    T toUpOrDown(Integer input);

}
