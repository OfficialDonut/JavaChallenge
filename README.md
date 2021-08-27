# Java Challenge
This is a deceptive program I contrived that incorporates many of the pitfalls and subtle details of the Java programming language. Can you avoid stepping on the numerous logical landmines scattered throughout the program and correctly determine its output?

<details>
  <summary>Hints</summary>
  <details>
    <summary>Line 11</summary>
    Character ASCII codes
  </details>
  <details>
    <summary>Line 12</summary>
    Byte can overflow
  </details>
  <details>
    <summary>Line 20</summary>
    Small autoboxed numbers are cached
  </details>
  <details>
    <summary>Line 21</summary>
    If/else indentation is meaningless
  </details>
  <details>
    <summary>Line 25</summary>
    Strings are immutable
  </details>
  <details>
    <summary>Line 27</summary>
    Split uses regex
  </details>
  <details>
    <summary>Line 29</summary>
    Switch cases fall through
  </details>
  <details>
    <summary>Line 36</summary>
    Assignment to original value happens after postfix increment
  </details>
  <details>
    <summary>Line 37</summary>
    The condition always short circuits
  </details>
  <details>
    <summary>Line 45</summary>
    Remove index method is called
  </details>
  <details>
    <summary>Line 51</summary>
    Integer division
  </details>
  <details>
    <summary>Line 66</summary>
    If `this` is of type B then B's bar method is called
  </details>
  <details>
    <summary>Line 76</summary>
    Implicit superclass constructor
  </details>
  <details>
    <summary>Line 89</summary>
    Method signature does not match Object's equals
  </details>
</details>

<details>
  <summary>Answer</summary>
  1
</details>

```java
import java.util.ArrayList;
import java.util.List;

public class Challenge {

    public static void main(String[] args) {
        A a = new B(2);
        B b = (B) a;
        a.foo();

        byte num = b.equals(a) ? (byte) '2' : (byte) '1';
        num += a.num + 70;

        int result = num;

        Integer x = 101;
        Integer y = 101;

        if (x.equals(y))
            if (x != y) result += 321;
        else
            result += 123;

        String str = "192.168.2.1";
        str.concat(":25565");

        int len = str.split(str.substring(7, 9)).length;

        switch (len) {
            case 2: result += 7;
            case 3: result += 5;
            case 4: result += 3;
        }

        for (int i = len; i > 0; i--) {
            result = result++;
            if (i <= 0 && ++result >= 0) {
                break;
            }
        }

        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.remove(1);

        List<Integer> l2 = l1;
        l2.add(3);
        l2.add(4);

        result /= (l1.get(0) + l2.get(0));

        System.out.println(result);
    }

    private static class A {

        public int num = 0;

        public A() {
            this.num++;
        }

        public void foo() {
            this.num++;
            this.bar();
        }

        public void bar() {
            this.num += 2;
        }
    }

    private static class B extends A {

        public B(int n) {
            this.num += n;
        }

        public void foo() {
            this.num++;
            super.foo();
        }

        public void bar() {
            this.num += 3;
        }

        public boolean equals(B b) {
            return false;
        }
    }
}
```
