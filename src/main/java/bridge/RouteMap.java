package bridge;

import java.util.ArrayList;
import java.util.List;

public class RouteMap {

    private static final String MOVE_FAILURE = "X";
    protected final List<String> upSide;
    protected final List<String> downSide;
    private final MapFormat mapFormat = MapFormat.FORMAT;

    public RouteMap(List<String> upSide, List<String> downSide) {
        this.upSide = upSide;
        this.downSide = downSide;
    }

    public List<String> format() {
        return mapFormat.convertToFormatStrings(List.of(upSide, downSide));
    }

    public RouteMap join(RouteMap other) {
        List<String> newUpSide = new ArrayList<>(upSide);
        List<String> newDownSide = new ArrayList<>(downSide);

        newUpSide.addAll(other.upSide);
        newDownSide.addAll(other.downSide);

        return new RouteMap(newUpSide, newDownSide);
    }

    public boolean fail() {
        return upSide.contains(MOVE_FAILURE) || downSide.contains(MOVE_FAILURE);
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof RouteMap) {
            return upSide.equals(((RouteMap) other).upSide)
                    && downSide.equals(((RouteMap) other).downSide);
        }
        return false;
    }

    @Override
    public String toString() {
        return "upSide: " + upSide + ", " + "downSide: " + downSide;
    }

}
