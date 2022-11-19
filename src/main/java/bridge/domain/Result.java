package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private final List<MoveStatus> status;
    private int location;

    public Result() {
        this.status = new ArrayList<>();
        this.location = 0;
    }

    public void update(Bridge bridge, String userDirection) {
        status.add(MoveStatus.of(bridge.canMove(userDirection, location), userDirection));
        location++;
    }

    public boolean isEnd(Bridge bridge) {
        return !status.get(status.size() - 1).didCross() || bridge.isEnd(location);
    }

    public List<String> toStrings() {
        String upSide = buildBridge(Direction.UPSIDE.shortcut());
        String downSide = buildBridge(Direction.DOWNSIDE.shortcut());

        return List.of(upSide, downSide);
    }

    private String buildBridge(String direction) {
        StringBuilder bridgeBuilder = new StringBuilder();

        for (MoveStatus moveStatus : status) {
            bridgeBuilder.append(moveStatus.generateMark(direction));
        }

        return bridgeBuilder.toString();
    }
}
