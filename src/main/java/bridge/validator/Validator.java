package bridge.validator;

import bridge.domain.Command;

import java.util.List;

public final class Validator {
    public static void validateListLengthInRange(List list, int startInclusive, int endInclusive)
            throws IllegalArgumentException{
        if(list.size()<startInclusive || list.size()>endInclusive){
            throw new IllegalArgumentException();
        }
    }

    public static void validateIsStringCommand(String string, Command command1, Command command2)
            throws IllegalArgumentException{
        if(!string.equals(command1.getValue()) && !string.equals(command2.getValue())){
            throw new IllegalArgumentException();
        }
    }
}
