# 다리 건너기
## 🚀 기능 요구 사항
위아래 둘 중 하나의 칸만 건널 수 있는 다리를 끝까지 건너가는 게임이다.
- 위아래 두 칸으로 이루어진 다리를 건너야 한다.
- 다리의 길이를 숫자로 입력받고 생성한다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다.
  - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다.
  - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다.
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다.

## 기능 목록 
1. 다리의 길이를 입력받는다.　　`InputView#readBridgeSize()`
2. 다리를 생성한다.
- [x] 무작위로 0과 1중 하나를 선택한다.　　`BridgeRandomNumberGenerator#generate()`
- [x] `"U", "D"` 형태로 저장한다.　　`BridgeMaker#makeBridge`
3. 사용자로부터 다리를 이동할 칸을 입력받는다. 　　`InputView#readMoving()`
- [x] 다리를 건널 수 있는지 없는지 판단한다. 　　`RunController#compare()`
4. 다리를 이동한다. 　　`BridgeGame#move()`
5. 다리를 이동한 칸을 출력한다.
- [x] 건널 수 있으면 O, 없으면 x로 표시한다. 　　`RunController#saveUserMoving()`
6. 게임 결과를 저장한다.  　　`BridgeController#saveGameResult()`
- [x] 시도한 횟수를 저장한다.
- [x] 다리를 끝까지 건너면 성공의 결과를 저장한다. 
- [x] 다리를 끝까지 못건널 경우 실패의 결과를 저장한다.
7. 게임 결과를 출력한다 　　`OutputView#printResult()`
- [x] 실패 시, 재시도 여부를 묻는다.　　`InputView#readGameCommand()`
  - [x] 재시도일 경우 3부터 재시작한다. 　　`BridgeController#saveGameResult()`
  - [x] 종료일 경우, 시도한 횟수와 성공 여부를 출력한다. 　　`BridgeController#stop()`
- [x] 성공 시, 시도한 횟수와 성공 여부를 출력한다.　　 

<hr/>

### 예외 처리 
#### 입력값에 대한 예외
1. 다리의 길이에 대한 예외 
- [x] 3 ~ 20 범위에 해당하지 않을 경우
- [x] 숫자가 아닌 경우 
2. 이동할 값에 대한 예외 
- [x] U, D로 입력하지 않았을 경우 
- [x] 소문자도 해당 안됨
3. 재시작 여부에 대한 예외 
- [x] R, Q로 입력하지 않았을 경우
