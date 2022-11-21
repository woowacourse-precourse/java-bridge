package bridge.service;

public class TypeChange {

    private final String Number_REGEX = "^\\d+$";

    public int ChangeStringToInteger(String size) {

        if(!(size.matches(Number_REGEX))){
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        return Integer.parseInt(size);
    }
}
