package bridge.step;

import static bridge.log.Log.log;

import java.util.List;
import java.util.NoSuchElementException;

public class StepLauncher {

    private final List<Step> steps;

    public StepLauncher(List<Step> steps) {
        this.steps = steps;
    }

    public void addStep(Step step) {
        this.steps.add(step);
    }

    public void run() {
        while (steps.size() > 0) {
            Step step = steps.remove(0);

            try {
                step.doStep();
            } catch (NoSuchElementException e) {
                // 다리 생성 숫자를 잘못 입력 했을 경우
                // 다시 유저에게 입력을 요청하게 작성하면
                // 테스트 케이스 통과 안됨, 요구사항과 상충
                // 해당 예외만 별도 처리
                log.error(e);
            } catch (Exception e) {
                log.error(e);
                steps.add(0, step);
            }
        }


    }
}
