package bridge.model;

public enum Direction {

    UP("U", 1),
    DOWN("D", 0);

    private final String direction;
    private final int generateCode;

    Direction(String direction, int generateCode) {
        this.direction = direction;
        this.generateCode = generateCode;
    }

    public String getDirection() {
        return direction;
    }

    public boolean isMatchDirection(String direction) {
        return this.direction.equals(direction);
    }

    public boolean isMatchGenerateCode(int code) {
        return generateCode == code;
    }

}
