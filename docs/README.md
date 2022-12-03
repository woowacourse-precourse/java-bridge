# 미션 - 다리 건너기

## 게임 이해

위, 아래(0, 1) 둘 중 하나의 칸만 건널 수 있는 다리를 건너가는 게임으로

사용자로 부터 다리 개수를 입력 받고, 어떤 칸을 건널 수 있는지는 랜덤으로 정해져 있다.

왼쪽에서 오른쪽으로(0->N) 다리를 건넌다.

각 라운드 마다 사용자가 위로 건널지 아래로 건널지 입력 받고 그에 맞게 이동한다.

성공 할 경우 해당 칸에 O 를

실패 할 경우 해당 칸에 X 를 그려 출력한다.

다리를 끝까지 건너면 게임이 종료된다.

중간에 실패 할 경우 게임을 재시작 하거나 종료할 수 있다.

재시작할 경우 전에 만든 다리를 활용해, 게임을 진행한다.

## 프로그램 구조

```
다리 생성
게임 시작
  사용자 이동
     이동 성공 시 다음 진행
     이동 실패 시
         게임 재시작 여부 확인
             재시작 원할 경우 재시작
게임 종료
```

## 기능 목록

- [O] 사용자로 부터 다리 길이를 입력 받는다. InputView#readBridgeSize
- [O] 다리 생성
    - [O] 다리의 건널 수 있는 칸을 정한다. BridgeRandomNumberGenerator#generate
    - [O] 입력 받은 수에 맞게 다리를 생성 한다. BridgeMaker#makeBridge
- [O] 게임 진행 BridgeGame#move
    - [O] 사용자에게 위로 건널지 아래로 건널지 입력 받는다. InputView#readMoving
    - [O] 사용자의 입력 값으로 해당 칸을 건널 수 있는지 없는지 판단한다.
        - [O] 해당 칸에 O,X 를 표시해 결과를 출력한다. OutputView#printMap
            - [O] 성공할 경우 게임을 계속 진행한다.
                - [O] 다리를 끝까지 건너면 게임이 종료된다.
            - [O] 실패 할 경우 게임을 재시작 하거나 종료할지 입력 받는다. InputView#readGameCommand
                - [O] 재시작할 경우 전에 만든 다리를 활용해, 게임을 진행한다. BridgeGame#retry
- [O] 게임 종료
- [O] 게임이 종료 될 경우 성공 여부 및 시도 횟수를 출력한다. OutputView#printResult

## 위의 기능 테스트 목록

- [O] 입력 받은 수에 맞게 다리를 생성 한다. BridgeMakerTest#makeBridge
- [O] 해당 칸을 건널 수 있는지 없는지 판단한다. - 성공 BridgeGameTest#movable
- [O] 해당 칸을 건널 수 있는지 없는지 판단한다. - 실패 BridgeGameTest#unmovable
- [O] 재시작할 경우 전에 만든 다리를 활용한다. BridgeGameTest#retry

## 기타 테스트 목록

- [O] 게임 초기화 BridgeGameTest#initGame
- [O] 0, 1을 위, 아래로 변환 BridgeMakerTest#convertNumberToString
- [O] 0, 1 으로 생성 되는지 확인 BridgeRandomNumberGeneratorTest#generate

