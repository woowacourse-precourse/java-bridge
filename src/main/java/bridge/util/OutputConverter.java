package bridge.util;

import bridge.constant.Direction;
import bridge.constant.MoveStatus;
import java.util.List;

public class OutputConverter {

    public static List<String> resultToStrings(List<MoveStatus> moveStatuses) {
        StringBuilder upSideBridgeBuilder = new StringBuilder();
        StringBuilder downSideBridgeBuilder = new StringBuilder();

        buildBridges(moveStatuses, upSideBridgeBuilder, downSideBridgeBuilder);

        return List.of(downSideBridgeBuilder.toString(), upSideBridgeBuilder.toString());
    }

    private static void buildBridges(List<MoveStatus> moveStatuses,
                                     StringBuilder upSideBridgeBuilder,
                                     StringBuilder downSideBridgeBuilder) {
        for (MoveStatus moveStatus : moveStatuses) {
            upSideBridgeBuilder.append(moveStatus.generateMark(Direction.UPSIDE));
            downSideBridgeBuilder.append(moveStatus.generateMark(Direction.DOWNSIDE));
        }
    }

    private OutputConverter() {

    }
}
