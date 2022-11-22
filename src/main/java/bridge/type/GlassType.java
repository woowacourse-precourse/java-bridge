package bridge.type;

import bridge.Env;

public enum GlassType {
    TEMPERED(Env.CODE_OF_SAFE, true),
    NORMAL(Env.CODE_OF_UNSAFE, false);

    private final String typeName;
    private final Boolean isSafe;

    GlassType(String typeName, boolean isSafe) {
        this.typeName = typeName;
        this.isSafe = isSafe;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public boolean isSafe() {
        return this.isSafe;
    }
}
