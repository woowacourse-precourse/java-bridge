package bridge.validator;

import java.util.List;

public final class Validator {
    public static void validateListLengthInRange(List list, int startInclusive, int endInclusive)
            throws IllegalArgumentException{
        if(list.size()<startInclusive || list.size()>endInclusive){
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsStringOneCharacter(String string, String character1, String character2)
            throws IllegalArgumentException{
        if(!string.equals(character1) && !string.equals(character2)){
            throw new IllegalArgumentException();
        }
    }
}
