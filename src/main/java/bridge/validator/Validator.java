package bridge.validator;

import java.util.List;

public final class Validator {
    public static void validateListLengthInRange(List list, int startInclusive, int endInclusive)
            throws IllegalArgumentException{
        if(list.size()<startInclusive || list.size()>endInclusive){
            throw new IllegalArgumentException();
        }
    }
}
