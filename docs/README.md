# 요구 사항 분석

## 🚀 기능 요구사항 리스트
1. 다리 길이를 입력받고 다리를 생성한다
   1) 사용자에게 다리 길이를 입력 받는다 (input.1)
   2) 다리 길이만큼 0, 1 중 무작위로 선택한다. (feat.1.1)
   3) 1: 위 칸으로 건널 수 있다면 U / 0: 아래 칸으로 건널 수 있으면 D 를 List<String>에 저장한다. (feat.1.2)
   4) 이를 게임이 종료할때까지 유지한다.
2. 매 게임마다 이동할 칸을 선택하여 다리를 건넌다.
   1) 사용자에게 이동할 칸을 입력 받는다 (input.2)
   2) 해당 다리가 건널 수 있는지 비교한다. (feat.2.1)
   3) 비교 후 채점표를 갱신한다. (feat.2.2)
   4) 결과 맵을 보여준다. (output.1)
   5) 다음 단계로 넘어간다. (output.2)
      1) 성공 & 아직 남은 다리가 있을 시 -> feat.2으로 
      2) 성공 & 남은 다리가 없을 시 -> 게임 종료 문구 
      3) 실패 -> 게임 종료 문구 & 게임 재시작 여부 문구 (feat.2.3)(input.3)

### Validation
1. 다리 길이 입력시 숫자인지 확인 - `IllegalArgumentException`
2. 다리 길이 입력시 3 이상 20 이하의 숫자인지 확인 - `IllegalArgumentException`
3. 입력받은 이동할 칸이 'U' , 'R'이 아닌 경우 - `IllegalArgumentException`

## 구조화(MVC)
[ MVC 패턴 ]<br>
View : 입출력 담당<br>
Controller : 요청 수행<br>
Model(Service) : BridgeMaker, BridgeGame
DTO : BridgeGameResultDto
Enum : UpDown

### InputView
```
public int readBridgeSize() (input.1)
public String readMoving()  (input.2)
public String readGameCommand   (input.3)
private void validateSizeType(String input)
private void validateSizeRange(String input)
```

### OutputView
```
public void printMap()  (output.1)
public void printResult()   (output.2)
```

### Controller
```
// 요청 수행 method
public BridgeGame prepareBridgeGame()
public void startBridgeGame(BridgeGame bridgeGame)
   ->
   * SUCCESS - result 빼고 break
   * FAIL - R : retry 호출
   *      - Q : result 빼고 break
   * ONGOING - 아무것도 안하고 그냥 감 
private boolean chooseAfterFail(BridgeGame bridgeGame, BridgeGameResultDto moveResult)
```

### BridgeMaker - 게임에서 필요한 bridgeMap 을 만들어주는 기계
```
[Field]<br>
BridgeNumberGenerator bridgeNumberGenerator

[constructor]<br>
this.

[method]<br>
public List<String> makeBridge(int size)  (feat.1.1)
private String makeRandomUpDown()
```

### BridgeGame - 게임을 진행하는 주최자, 채점판을 가지고 있고 매 시도마다 채점판은 갱신됨
```
[Field]<br>
List<Map<UpDown,Boolean>> gradingBoard - 채점판 (final이 안된다 밖으로 빼서 처리하는게 나을까 고민)
List<String> answerBridge - 정답 bridge (주최자가 정답을 가지고 있는게 더 자연스러운 흐름이라고 생각된다)

[constructor]<br>
this. 

[method]<br>
public BridgeGameResultDto move(String nextStep)    (feat.2.2)      
public void retry() (feat.2.3)
private boolean compareNextStep(String nextStep)    (feat.2.1) 
private BridgeGameResultDto bridgeGameResultDtoMapper(boolean isCorrect)
private void validateNextStep(String nextStep)
```

### BridgeGameResultDto
```
[Field]<br>
List<Map<UpDown,Boolean>> gradingBoard
boolean isCorrect

[constructor]<br>

```

### UpDown
```
[Field]<br>
UP("U",1), 
DOWN("D",0)

[constructor]<br>
UpDown(String label, int number)
this.

[method]<br>
getter
```

### 객체
```
[Field]<br>

[constructor]<br>

[method]<br>

```

## 추가 제약 사항
1. BridgeMaker 클래스는 필드, 메서드를 변경할 수 없다.
2. 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다. 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다. 
3. 메서드의 파라미터 개수는 최대 3개까지만 허용한다.
4. BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.