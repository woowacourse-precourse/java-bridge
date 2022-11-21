미션 - 다리 건너기

기능 구현 사항 :

<details>
<summary>다리 생성</summary>
<div markdown="1">

다리의 길이를 입력받고 길이에 맞게 2진수 다리 생성

</div>
</details>

------------------------------

<details>
<summary>플레이어 상호작용</summary>
<div markdown="1">

플레이어의 입력을 받고 플레이어의 이동 및 게임 재시작 등 플레이어 상호작용

</div>
</details>

-------------------------------

<details>
<summary>게임 전체 진행</summary>
<div markdown="1">

다리와 플레이어를 객체로 받아서 다리건너기 게임을 진행

</div>
</details>

-------------------------------

<details>
<summary>예외 처리</summary>
<div markdown="1">

다리길이 3-20 사이인지, 플레이어입력값 U,D인지, 재시작 종료여부 R,Q인지

문제 명시사항 

- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

</div>
</details>

-------------------------------

<details>
<summary>추가 요구 사항</summary>
<div markdown="1">

- BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.

- InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine() 메서드를 이용해 사용자의 입력을 받을 수 있다.

</div>
</details>

