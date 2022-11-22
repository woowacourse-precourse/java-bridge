---
# 기능 구현 목록

## Model
### Bridge
- [x] up, down 방향마다 다리를 형성
    - player 에게 입력받은 방향으로 up 다리와 down 다리에 결과를 저장하는 것
    - [x] 초기화 기능 : 재시도 시에 그 전 결과 삭제를 위해
    - [x] update 기능 : user 가 방향을 입력할 때마다 그에 대한 결과 반영
    - [x] get 기능 : user 가 방향 입력 후, update 된 결과 받기
    - [x] rightAnswer 기능 : 만약, 사용자가 틀린 방향을 입력했다면 이 결과를 반영해놓고 결과 출력 후, 재시도 여부 물어보기 위해

### InputView
- [x] 다리 길이 입력받기

  - [x] 3 이상 20 이하 입력 예외처리
  - [x] 숫자만 예외처리

- [x] 사용자 이동 입력받기

  - [x] U, D 이 아닌 입력 예외처리

- [x] 게임 재시작/종료 입력받기

  - [x] R, Q 값이 아닌 입력 예외처리



### BridgeMaker
- [x] user 에게 입력받은 사이즈에 따라 다리 생성

  - 어디가 가능한 다리인지 생성해서 반환하는 것

### BridgeJudge
- [x] 위의 방향, 아래 방향 마다 다리 map 그려놓고 반환
  - [x] setBridge : 현재까지 진행한 라운드만큼 그려놓는 기능
    - [x] saveMap: 판단 결과로 맵 ArrayList 에 저장
      - judgeIndex: 인덱스로 어떻게 그려야 하는지 판단

        `index = 0 : 첫 시작이므로 여는 괄호 '['`

        `index 홀수 : 사용자 답에 대한 결과 출력`

        `index 짝수 & 마지막 X : '|' 중간 다리 출력`

        `index 마지막 : 닫는 괄호 ']'`
- [x] 초기화 함수 : 재시작 시, 지금까지 라운드 기록 지우기 위해

- [x] BridgeMaker 에서 생성된 다리(가능한 방향을 ArrayList 로 담아놓은 것)를 매개변수로 받아서 사용자 입력값도 매개변수로 받기

  - [x] judgeReflect: 두 개를 비교해서 같으면 사용자 입력값에 따라 Bridge 객체에 반영
    - [x] 사용자 값 == 정답
      - "U" 인데, 같을 경우 : up 에 O 저장, down 에 공백 저장
      - "D" 인데, 같을 경우 : down 에 O 저장, up 에 공백 저장
    - [x] 사용자 값 != 정답
      - "U" 인데, 틀릴 경우 : up 에 X 저장, down 에 공백 저장, Bridge flug false 로 변경
      - "D" 인데, 틀릴 경우 : down 에 X 저장, up 에 공백 저장 , Bridge flug false 로 변경

## View
### OutputView
- [x] 라운드마다 결과 출력 : 라운드 결과 매개변수로 받아서
- [x] 최종 결과 출력

## Controller
### BridgeGame : game 진행을 위한 필드 존재
- [x] 이동하는 기능
  - madeBridge 와 userDirection 를 매개변수로 받아서, BridgeJudge 를 이용하여 결과 반영
- [x] 다시 시도하는 기능
  - 다시 시도할지 사용자한테 받아서 true, false 반환

### Application
- [x] 게임 진행 기능
---