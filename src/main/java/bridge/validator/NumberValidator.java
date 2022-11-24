package bridge.validator;

import java.util.stream.Stream;

public interface NumberValidator {
    default boolean isNumeric(String target) {
        boolean numeric = target.chars().allMatch(Character::isDigit);
        if(numeric){
            return true;
        }
        return false;
    }
}
