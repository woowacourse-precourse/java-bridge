package bridge.model;

import java.util.List;

public class Player {

    private int position;
    private int tryCount;
    private Bridge bridge;

    public Player(Bridge bridge)
    {
        this.bridge = bridge;
        this.position = 0;
        this.tryCount = 0;
    }

    public Player(List<String> bridge)
    {
        this.bridge = new Bridge(bridge);
        this.position = 0;
        this.tryCount = 0;
    }

    public boolean move(String nextMove)
    {
         boolean flag = bridge.isMovable(position,nextMove);
         tryCount++;
         if(flag) position += 1;
         return flag;
    }

    public boolean isFinish()
    {
        return bridge.isFinish(position);
    }

    @Override
    public String toString()
    {
        String gameFinish = isFinish() ? "성공" : "실패";
        String gameFinishMessage = String.format("게임 성공 여부: %s",gameFinish);
        String tryCountMessage = String.format("총 시도한 횟수: %d\n",tryCount);
        return String.join("\n",gameFinishMessage,tryCountMessage);
    }
}
