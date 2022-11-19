## 기능 요구 사항

- 위아래 두 칸으로 이루어진 다리를 건너야 한다. - BridgeGame
  - 다리는 왼쪽에서 오른쪽으로 건너야 한다. - BridgeGame#move
  - 위아래 둘 중 하나의 칸만 건널 수 있다. - ``
- 다리의 길이를 숫자로 입력받고 생성한다. - InputView#readBridgeSize -> BridgeMaker:constructor
  - 다리를 생성할 때 위 칸과 아래 칸 중 건널 수 있는 칸은 0과 1 중 무작위 값을 이용해서 정한다. - BridgeMaker#generate
  - 위 칸을 건널 수 있는 경우 U, 아래 칸을 건널 수 있는 경우 D값으로 나타낸다. - BridgeMaker#makebrdige
  - 무작위 값이 0인 경우 아래 칸, 1인 경우 위 칸이 건널 수 있는 칸이 된다.
- 다리가 생성되면 플레이어가 이동할 칸을 선택한다. - InputView#readMoving
  - 이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D를 입력한다. BridgeMaker#makeBridge -> BridgeGame#move
  - 이동한 칸을 건널 수 있다면 O로 표시한다. 건널 수 없다면 X로 표시한다. OutputView#printMap
- 다리를 끝까지 건너면 게임이 종료된다.
- 다리를 건너다 실패하면 게임을 재시작하거나 종료할 수 있다. InputView#readGameCommand -> BridgeGame#retry
  - 재시작해도 처음에 만든 다리로 재사용한다.
  - 게임 결과의 총 시도한 횟수는 첫 시도를 포함해 게임을 종료할 때까지 시도한 횟수를 나타낸다. OutputView#printResult
---

## 기능 구현 목록

- (1) 인풋
  - readBridgeSize
    - [] 다리의 길이를 입력받는다
    - 예외처리
      - [V] 숫자가 아닌값
      - [] 3이상 20이하의 범위를 벗어난 값

  - readMoving
    - [] 이동할 칸을 입력받는다
    - 예외처리
      - [] U,D 입력이 아닌 경우

  - readGameCommand
    - [] 게임 재시작/종료 여부를 입력 받는다.
    - 예외처리
      - [] R,Q 입력이 아닌 경우
---
  - (2) 아웃풋
    - printMap
      - [] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
    
    - printResult
      - [] 게임의 최종 결과 출력
---
  - (3) BridgeMaker
    - makeBridge
      - [] 다리의 길이와 모양에 따른 모양 출력
      - 예외처리
        - 올바르지 않은 다리의 길이 입력
---
  - (4) BridgeGame
    - move
      - [] 칸을 이동한다
    
    - retry
      - [] 게임을 다시 시도한다
      - 예외처리
        - 올바르지 않은 입력