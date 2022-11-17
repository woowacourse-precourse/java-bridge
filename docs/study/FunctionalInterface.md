# 함수형 인터페이스(Functional Interface)

- 1 개의 추상 메소드를 갖는 인터페이스
- 여러 개의 디폴트 메서드가 있더라도 추상 메서드가 오직 하나면 함수형 인터페이스
    - `default method` 또는 `static method` 는 여러 개 존재해도 상관 없음
- 자바의 **람다 표현식**은 함수형 인터페이스로만 사용 가능

---

### `@FunctionalInterface`

- 해당 인터페이스가 함수형 인터페이스 조건에 맞는지 검사해주는 어노테이션
- 함수형 인터페이스로 동작하고 사용하는 데 문제는 없지만, 인터페이스 검증과 유지보수를 위해 붙여주는 게 좋음

---

### Java 에서 기본적으로 제공하는 Functional Interfaces

#### Predicate

``` 
@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
```

- `Predicate` 는 인자 하나를 받아서 `boolean` 타입을 리턴
- 람다식으로는 `T -> boolean` 로 표현

#### Consumer

``` 
@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}
```

- `Consumer` 는 인자 하나를 받고 아무것도 리턴하지 않음
- 람다식으로는 `T -> void` 로 표현
- 소비자라는 이름에 걸맞게 무언가 (인자) 를 받아서 소비만 하고 끝냄

#### Supplier

``` 
@FunctionalInterface
public interface Supplier<T> {
    T get();
}
```

- `Supplier` 는 아무런 인자를 받지 않고 T 타입의 객체를 리턴
- 람다식으로는 `() -> T` 로 표현
- 공급자라는 이름처럼 아무것도 받지 않고 특정 객체를 리턴

#### Function

``` 
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

- `Function` 은 T 타입 인자를 받아서 R 타입을 리턴
- 람다식으로는 `T -> R` 로 표현
- 수학식에서의 함수처럼 특정 값을 받아서 다른 값으로 반환

#### Comparator

``` 
@FunctionalInterface
public interface Comparator<T> {
    int compare(T o1, T o2);
}
```

- `Comparator` 은 T 타입 인자 두개를 받아서 int 타입을 리턴
- 람다식으로는 `(T, T) -> int` 로 표현

#### Runnable

``` 
@FunctionalInterface
public interface Runnable {
    public abstract void run();
}
```

- Runnable 은 아무런 객체를 받지 않고 리턴도 하지 않음
- 람다식으로는 `() -> void` 로 표현
- `Runnable` 이라는 이름에 맞게 "실행 가능한" 이라는 뜻을 나타내며 이름 그대로 실행만 가능

#### Callable

``` 
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

- `Callable` 은 아무런 인자를 받지 않고 T 타입 객체를 리턴
- 람다식으로는 `() -> T` 로 표현
- `Supplier`와 완전히 동일함