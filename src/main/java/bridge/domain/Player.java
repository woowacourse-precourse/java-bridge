package bridge.domain;

public class Player {

    private static final int START_POSITION_VALUE = 0;
    private static final String START_LAST_SELECTION_VALUE = "";
    private static final boolean START_LIFE_VALUE = true;

    private int position;
    private String lastSelection;
    private boolean isAlive;

    public Player() {
        this.position = START_POSITION_VALUE;
        this.lastSelection = START_LAST_SELECTION_VALUE;
        this.isAlive = START_LIFE_VALUE;
    }

    public int getPosition() {
        return position;
    }

    public String getLastSelection() {
        return lastSelection;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void updateSelection(String playerSelection) {
        this.lastSelection = playerSelection;
    }

    public void die() {
        this.isAlive = false;
    }

    public void updatePosition() {
        this.position++;
    }

    public boolean matches(String answer) {
        return lastSelection.equals(answer);
    }
}
