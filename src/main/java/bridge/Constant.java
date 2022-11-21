package bridge;

public enum Constant {
    RANGE_START(1),
    RANGE_END(21),
    UP_CONTROL_ASCII(85),
    DOWN_CONTROL_ASCII(68),
    RESTART_CONTROL_ASCII(82),
    STOP_CONTROL_ASCII(81),
    UP_CONTROL(1),
    DOWN_CONTROL(0),
    MOVE_DISTANCE(1)
    ;
    final int constant;

    public int getConstant() {
        return constant;
    }

    Constant(int constant) {
        this.constant = constant;
    }
}
