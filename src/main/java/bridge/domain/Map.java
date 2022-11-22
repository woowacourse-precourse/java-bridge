package bridge.domain;

import static bridge.ExceptionConst.*;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_END = " ]\n";
    private static final String BRIDGE_MIDDLE = " | ";

    private final Bridge bridge;
    private final User user;
    private final List<ResultFlag> upper = new ArrayList<>();
    private final List<ResultFlag> lower = new ArrayList<>();

    public Map(Bridge bridge, User user) {
        this.bridge = bridge;
        this.user = user;
    }

    public void update() {
        if (user.getMovedLength() > bridge.getLength()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_BRIDGE_LENGTH_OVER_USER);
        }
        upper.clear();
        lower.clear();
        draw(user.getMovedPosition(), bridge.getBridge());
    }

    private void draw(List<UpDownFlag> userUpDowns, List<UpDownFlag> bridgeUpDowns) {
        for (int i = 0; i < userUpDowns.size(); i++) {
            UpDownFlag bridgeUpdown = bridgeUpDowns.get(i);
            UpDownFlag userUpDown = userUpDowns.get(i);
            if (bridgeUpdown == userUpDown) {
                crossSuccess(userUpDown);
            }
            if (bridgeUpdown != userUpDown) {
                crossFail(userUpDown);
            }
        }
    }

    private void crossSuccess(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperSuccess();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerSuccess();
        }
    }

    private void crossFail(UpDownFlag userUpDown) {
        if (userUpDown == UpDownFlag.UP) {
            crossUpperFail();
        }
        if (userUpDown == UpDownFlag.DOWN) {
            crossLowerFail();
        }
    }

    private void crossUpperSuccess() {
        upper.add(ResultFlag.SUCCESS);
        lower.add(ResultFlag.NOTHING);
    }

    private void crossLowerSuccess() {
        upper.add(ResultFlag.NOTHING);
        lower.add(ResultFlag.SUCCESS);
    }

    private void crossUpperFail() {
        upper.add(ResultFlag.FAIL);
        lower.add(ResultFlag.NOTHING);
    }

    private void crossLowerFail() {
        upper.add(ResultFlag.NOTHING);
        lower.add(ResultFlag.FAIL);
    }

    @Override
    public String toString() {
        return render(upper) + render(lower);
    }

    private String render(List<ResultFlag> list) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BRIDGE_START);
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                stringBuilder.append(BRIDGE_MIDDLE);
            }
            stringBuilder.append(list.get(i));
        }
        stringBuilder.append(BRIDGE_END);
        return stringBuilder.toString();
    }
}
