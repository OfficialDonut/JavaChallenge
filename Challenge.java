import java.util.ArrayList;
import java.util.List;

public class Perplexity {

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
