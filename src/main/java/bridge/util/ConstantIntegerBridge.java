package bridge.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/17
 */
public enum ConstantIntegerBridge {
    LENGTH_LOWER_BRIDGE(3)
    , LENGTH_UPPER_BRIDGE(20)
    , RANDOM_LOWER_INCLUSIVE(0)
    , RANDOM_UPPER_INCLUSIVE(1)
    ;
    private final int constant;

    ConstantIntegerBridge(int constant) {
        this.constant = constant;
    }

    public int getConstant() {
        return constant;
    }
}
