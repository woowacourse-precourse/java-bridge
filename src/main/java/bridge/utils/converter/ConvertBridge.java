package bridge.utils.converter;

public class ConvertBridge implements Converter<Integer, String> {

    @Override
    public String toUpOrDown(Integer input) {
        if (input == 1)
            return "U";
        if (input == 0)
            return "D";
        return null;
    }

}
