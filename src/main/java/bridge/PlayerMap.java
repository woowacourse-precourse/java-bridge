package bridge;

import java.util.ArrayList;
import java.util.List;

public class PlayerMap {

    private static final String MOVE_FAILURE = "X";
    protected final List<String> upSide;
    protected final List<String> downSide;
    private final MapFormat mapFormat = MapFormat.FORMAT;

    public PlayerMap(List<String> upSide, List<String> downSide) {
        this.upSide = upSide;
        this.downSide = downSide;
    }

    public List<String> toStringsByFormat() {
        return mapFormat.convertToFormatStrings(List.of(upSide, downSide));
    }

    public PlayerMap join(PlayerMap other) {
        List<String> newUpSide = new ArrayList<>(upSide);
        List<String> newDownSide = new ArrayList<>(downSide);

        newUpSide.addAll(other.upSide);
        newDownSide.addAll(other.downSide);

        return new PlayerMap(newUpSide, newDownSide);
    }

    public boolean isFailure() {
        return upSide.contains(MOVE_FAILURE) || downSide.contains(MOVE_FAILURE);
    }

    public PlayerMap subMapBy(int distance) {
        List<String> slicedUpSide = new ArrayList<>(upSide.subList(0, distance));
        List<String> slicedDownSide = new ArrayList<>(downSide.subList(0, distance));

        return new PlayerMap(slicedUpSide, slicedDownSide);
    }

    public PlayerMap getElementOf(int distance) {
        List<String> upSideStatus = List.of(upSide.get(distance - 1));
        List<String> downSideStatus = List.of(downSide.get(distance - 1));

        return new PlayerMap(upSideStatus, downSideStatus);
    }
    @Override
    public boolean equals(Object other) {
        if (other instanceof PlayerMap) {
            return upSide.equals(((PlayerMap) other).upSide)
                    && downSide.equals(((PlayerMap) other).downSide);
        }
        return false;
    }

    @Override
    public String toString() {
        return "upSide: " + upSide + ", " + "downSide: " + downSide;
    }

}
