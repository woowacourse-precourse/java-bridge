## 기능 구현 목록

- (1) 인풋
  - readBridgeSize
    - [V] 다리의 길이를 입력받는다
    - 예외처리
      - [V] 숫자가 아닌값
      - [V] 3이상 20이하의 범위를 벗어난 값
  - BridgeSize 예외처리 메소드
    - [V] 에러메시지 출력

  - readMoving
    - [V] 이동할 칸을 입력받는다
    - 예외처리
      - [V] U,D 입력이 아닌 경우
  - readMoving 예외처리 메소드
    - [V] 에러메시지 출력

  - readGameCommand
    - [V] 게임 재시작/종료 여부를 입력 받는다.
    - 예외처리
      - [V] R,Q 입력이 아닌 경우
  - readGameCommand 예외처리 메소드
    - [V] 에러메시지 출력
---
  - (2) 아웃풋
    - printMap
      - [V] 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
    
    - printResult
      - [V] 게임의 최종 결과 출력
---
  - (3) BridgeMaker
    - makeBridge
      - [V] 다리의 길이와 모양에 따른 모양 출력
      - [V] checkUpperBridge : 위칸인지 확인 하는 메소드
    - 예외처리
      - 올바르지 않은 다리의 길이 입력
      
---
  - (4) BridgeGame
    - move
      - [V] 칸을 이동한다
      - [V] 올바른 칸을 이동했는지 표시한다
    - retry
       - [V] 게임을 다시 시도한다
       - 예외처리
         - 올바르지 않은 입력
    - 올바른 다리로 이동했는지 기록하는 메소드
    - 실패한 위치의 기록을 지우는 메소드
