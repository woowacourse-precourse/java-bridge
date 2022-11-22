package constants;

import java.util.Map;

public class TableAccessor {
    public static Map<String, String> directionTableAccessor = Map.of(
            DirectionTable.DOWN.getInitial(), "DOWN",
            DirectionTable.UP.getInitial(), "UP",
            DirectionTable.NOT_DOWN.getInitial(), "NOT_DOWN",
            DirectionTable.NOT_UP.getInitial(), "NOT_UP"
    );

    public static Map<Integer, String> resultTableAccessor = Map.of(
            ResultTable.PASS.getResultNumber(), "PASS",
            ResultTable.FAIL.getResultNumber(), "FAIL",
            ResultTable.END.getResultNumber(), "END"
    );
}
