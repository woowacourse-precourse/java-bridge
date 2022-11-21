package bridge.validator;

import bridge.domain.Key;

public class MovingValidator {
    public static void validate(String input){
        if (!input.equals(Key.UP.command()) && !input.equals(Key.DOWN.command())){
            System.out.println("[ERROR] 이동은 U, D로만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

}
