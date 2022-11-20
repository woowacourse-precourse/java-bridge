package bridge.util;

import bridge.domain.Direction;
import bridge.domain.MoveStatus;
import bridge.domain.Result;
import java.util.List;

public class OutputConverter {

    public static List<String> resultToStrings(Result result) {
        StringBuilder upSideBridgeBuilder = new StringBuilder();
        StringBuilder downSideBridgeBuilder = new StringBuilder();

        buildBridges(result, upSideBridgeBuilder, downSideBridgeBuilder);

        return List.of(downSideBridgeBuilder.toString(), upSideBridgeBuilder.toString());
    }

    private static void buildBridges(Result result,
                                     StringBuilder upSideBridgeBuilder,
                                     StringBuilder downSideBridgeBuilder) {
        for (MoveStatus moveStatus : result.getStatus()) {
            upSideBridgeBuilder.append(moveStatus.generateMark(Direction.UPSIDE));
            downSideBridgeBuilder.append(moveStatus.generateMark(Direction.DOWNSIDE));
        }
    }
}
