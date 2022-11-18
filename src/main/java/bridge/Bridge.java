package bridge;

import java.util.List;

public class Bridge {
    private List<Command> answers;

    public Bridge(List<Command> answers) {
        this.answers = answers;
    }

    //비교 할 수 있는 메서드.
    public Result compare(Command command, int index) {
        if (this.answers.get(index).equals(command)) {
            return Result.SUCCESS;
        }
        return Result.FAIL;
    }
}
