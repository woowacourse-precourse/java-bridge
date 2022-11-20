package bridge;

public class History {

    private final int position;
    private final String moveDirection;
    private final boolean moveSucess;

    public History(int position, String moveDirection, boolean moveSucess) {
        this.position = position;
        this.moveDirection = moveDirection;
        this.moveSucess = moveSucess;
    }
}
