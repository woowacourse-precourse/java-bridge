package bridge.model;

import java.util.Arrays;

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

    public int getGenerateCode() {
        return generateCode;
    }

    public static Direction from(String input) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getDirection().equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("해당하는 방향이 존재하지 않습니다. 입력 : %s", input)));
    }

    public static Direction by(int code) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.getGenerateCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        String.format("생성 불가능한 코드입니다. 입력 : %d", code)));
    }

}
