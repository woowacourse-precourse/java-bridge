package constant;

public enum BothSideConstant {
    UP_SIDE_INDEX(1),
    DOWN_SIDE_INDEX(0);

    public final int bothSideConstant;

    BothSideConstant(final int bothSideConstant) {
        this.bothSideConstant = bothSideConstant;
    }

    public int getConstant() {
        return bothSideConstant;
    }
}
