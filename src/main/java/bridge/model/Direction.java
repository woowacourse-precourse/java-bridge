package bridge.model;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private final String input;
    private final int value;

    Direction(String input, int value){
        this.input = input;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getInput() {
        return input;
    }

    public static String getInputByValue(int value){
        if(value == Direction.UP.getValue()){
            return Direction.UP.getInput();
        }
        return Direction.DOWN.getInput();
    }

    public static Direction getDirectionByInput(String input){
        if(input.equals(Direction.UP.getInput())){
            return Direction.UP;
        }

        return Direction.DOWN;
    }
}
