package bridge;

enum Direction {
    UP, DOWN;

    public static Direction getInstance(String direction) {
        if (direction.equals("U")) {
            return UP;
        }
        return DOWN;
    }
}
