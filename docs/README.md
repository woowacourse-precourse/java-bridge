# [미션 설명]
- 다리의 길이가 주어지고 다리를 다 건너게 되면, 그동안 시도한 횟수를 출력하는 미션이다. 
- 그런데 다리의 칸별로 위, 아래 중에서 건널 수 있는 칸이 랜덤으로 정해지기 때문에 건널 수 있는 칸으로 이동하면
계속 게임을 이어가고, 건널 수 없는 칸으로 이동하면 실패로 간주해 게임이 종료된다. 
- 이때 재시작을 하면 동일한 다리로 다시 게임을 진행하고, 
종료를 선택하면 게임 결과를 출력하고 종료한다.
- 올바른 칸으로만 이동해 모든 다리를 다 건너면, 그동안의 시도 횟수와 최종 다리 상태를 출력한다. 

<br/>

# [기능 구현 목록]
## 입력 (InputView)
### 1. 다리 길이 입력 (readBridgeSize)
### 2. 라운드마다 이동할 칸 입력 (readMoving)
### 3. 실패시, 재시작/종료 여부 입력 (readGameCommand)

- - -
## 다리 생성 (BridgeMaker)
### 1. 다리 길이만큼 U or D 부여해 배열로 반환 (makeBridge)

- - -
## 게임 진행 (BridgeGame)
### 1. 칸을 움직인 결과 배열을 저장할 instance variable(bridgeState) 추가
### 2. 칸 이동 (move)
- input = U or D
- 이동할 칸이 올바른 bridge 칸이면 1 반환 & bridgeState 갱신
- 이동할 칸이 올바르지 않은 bridge 칸이면 -1 반환 & bridgeState 갱신
- 이동할 칸이 올바르고, bridge 배열의 끝이면 0 반환 & bridgeState 갱신
  - enum 이용
### 3. 게임 재시작 (retry)
- input = R or Q
- R이면 1 반환
- Q이면 -1 반환
- - - 

## 게임 컨트롤 (Application)
### 1. 게임 입,출력 함수 호출 및 BridgeGame의 move, retry 호출
### 2. move의 결과에 따라 retry 실행
- move 결과가 -1이면 retry 호출
### 3. retry의 결과에 따라 게임 종료
- retry 결과가 1이면 게임 재시작
- retry 결과가 -1이면 게임 종료 & 게임 결과 출력(printResult)
- - - 

## 출력 (OutputView)
### 1. 다리 상태 출력 (printMap)
- input = move()의 반환값 int, 다리 상태 담은 List
- 성공일시 O로, 실패일시 X로 다리 만들어 출력
### 2. 최종 다리 상태 출력 (printResult)
- input = 다리 상태 담은 List
- "최종 게임 결과" 멘트와 다리 만들어 출력
- 게임 성공 여부, 총 시도 횟수 출력


<br/>

# 요구 사항
### IllegalArgumentException 발생 및 [ERROR] message 출력.
- [x] 다리 길이 입력이 3 ~ 20 사이의 숫자가 아닌 경우
- [x] 이동할 칸 입력이 U 또는 D가 아닌 경우
- [x] 재시작/종료 입력이 R 또는 Q가 아닌 경우
