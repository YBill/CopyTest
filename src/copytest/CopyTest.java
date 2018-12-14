package copytest;

import java.util.ArrayList;
import java.util.List;

public class CopyTest {

    public static void main(String[] args) {

        int mInt1 = 5;

        int mInt2 = mInt1;

        mInt2 = 10;

        System.out.println(mInt1);
        System.out.println(mInt2);

        String mString1 = "5";

        String mString2 = mString1;

        mString2 = "10";

        System.out.println(mString1);
        System.out.println(mString2);

        MyChild1 myChild1 = new MyChild1(11, "mc11");
        MyBean1 myBean1 = new MyBean1(1, "s1", myChild1);
        List<MyChild1> list = new ArrayList<>(2);
        for (int i = 0; i < 2; i++) {
            MyChild1 child1 = new MyChild1(1000 + i, "aaa" + i);
            list.add(child1);
        }
        myBean1.setList(list);

        MyBean1 myBean2 = (MyBean1) myBean1.clone();
//        MyBean1 myBean2 = CloneUtils.clone(myBean1);

        myBean2.num = 2;
        myBean2.str = "s2";
        myBean2.myChild1.num = 22;
        myBean2.myChild1.str = "mc22";
        myBean2.list.get(0).str = "+++++a";
        myBean2.list.get(1).num = 9999;

        System.out.println(myBean1);
        System.out.println(myBean2);
        System.out.println("========");
        for (MyChild1 child1 : myBean1.list) {
            System.out.println(child1);
        }
        System.out.println("+++++++++++++");
        for (MyChild1 child1 : myBean2.list) {
            System.out.println(child1);
        }

    }

}
