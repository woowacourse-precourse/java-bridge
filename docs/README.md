---
# 기능 구현 목록

## Model
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

- [x] BridgeMaker 에서 생성된 다리(가능한 방향을 ArrayList 로 담아놓은 것)를 매개변수로 받아서 사용자 입력값도 매개변수로 받기

  - [x] 두 개를 비교해서 같으면 사용자 입력값에 따라 Bridge 객체에 반영
    - "U" 인데, 같을 경우 : up 에 O 저장, down 에 공백 저장
    - "D" 인데, 같을 경우 : down 에 O 저장, up 에 공백 저장
    - "U" 인데, 틀릴 경우 : up 에 X 저장, down 에 공백 저장, Bridge flug false 로 변경
    - "D" 인데, 틀릴 경우 : down 에 X 저장, up 에 공백 저장 , Bridge flug false 로 변경

## View
### OutputView
- [x] 사용자가 입력한 값과 원래 bridge 를 비교해서 받은 result 를 이용해 현재 bridge 출력 
  - count 를 받아서 처음과 끝만 괄호로 출력
  - index < count*2+1 만큼 돌려서 맵 그리기
  - index = 0 : 여는 괄호
  - index = 마지막 : 닫는 괄호
  - index 홀수 : 사용자 입력값 결과
  - index 짝수 : 중간 괄호(|)
- [x] 최종 결과 출력

## Controller
### BridgeGame
- [ ] 객체들의 함수를 이용해서 이동하는 함수
- [ ] 객체들의 함수를 이용해서 다시 시도하는 함수
---