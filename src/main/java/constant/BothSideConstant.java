package constant;

public enum BothSideConstant {
    UP_SIDE(1),
    DOWN_SIDE(0);

    public final int bothSideConstant;

    BothSideConstant(final int bothSideConstant) {
        this.bothSideConstant = bothSideConstant;
    }

    public int getBothSideConstant() {
        return bothSideConstant;
    }
}
