package bridge.ui;

import static bridge.ui.Expression.DOWN;
import static bridge.ui.Expression.UP;
import static bridge.ui.UserInterface.INVALID_EXCEPTION;
import static bridge.ui.UserInterface.QUIT;
import static bridge.ui.UserInterface.RE_TRY;

import java.util.List;
import java.util.Objects;


public class Exception {


    public static void validate(String readLine) {

        try {
            readLine.equals(null);

            List<String> commandLine = List.of(UP.expressThat(), DOWN.expressThat(), QUIT.interact(), RE_TRY.interact());
            commandLine.stream()
                    .filter(predicate -> Objects.equals(predicate, readLine.toCharArray()))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException(INVALID_EXCEPTION.interact()));


        }catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(INVALID_EXCEPTION.interact());
            throw new IllegalArgumentException(INVALID_EXCEPTION.interact());
        }
    }
}
