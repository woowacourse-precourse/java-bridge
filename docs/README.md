# 프리코스 4주차 기능목록

# Class

## `Application`

```
main 클래스 
역할
다리 개수 입력받기
유저 게임 시키기
종료관리
```

## `BridgeGame`

```
move()
main에서 호출시켜서 끝날때까지 반복문을 돌려서 
성공 -> OutputView 호출
실패 -> OutputView 호출 및 retry() 호출

retry() 
move 에서 호출당하면 게임을 재시작할껀지 종료할껀지 선택

 
```

## `BridgeMaker`

```
makeBridge() 
InputView 클래스의 메서드를 호출하여 글자수를 입력받아서
다리의 수를 생성하게 된다. 아래 메서드 호출
CanCrossTheBridge() 
생성 후엔 랜덤으로 건널 수 있는 다리와 건너지 못하는 다리를 결정
```

## `BridgeRandomNumberGenerator`

```
generate() 
랜덤으로 숫자를 정해주는 메서드 0 or 1 반환
```

## `InputView`

```
readBridgeSize()
다리길이를 입력받고 다리 길이를 호출해준다.

readMoving()
유저가 이동할 칸을 입력받는다.

readGameCommand()
사용자가 게임을 다시 시도할 지 종료할 지 여부를 입력

모두 Exeption 클래스를 통해 예외처리 진행
```

## `OutputView`

```
printMap()
현재까지 이동한 다리의 상태를 정해진 형식으로 출력
매번 출력해줘야함 !!!!

printResult() 
게임의 최종 결과를 출력해준다.
```

## `Exeption`

```
입력에 대한 예외처리를 해주는 클래스
예외처리 (오버로딩 활용하기)
- 다리길이 입력
숫자가 아닐 때
3과 20사이의 숫자가 아닐 때

- 이동할 칸을 입력 
U or D 가 아닐 때 만 처리해주면 될듯, , ?

- 게임 다시시도 여부 
R or Q 가 아닐 때

```