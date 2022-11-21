package bridge.domain.resources.converter;

public class ConvertBridge implements Converter<Integer, String> {

    @Override
    public String toUpOrDown(final Integer input) {
        if (input == 1)
            return "U";
        if (input == 0)
            return "D";
        return null;
    }

}
