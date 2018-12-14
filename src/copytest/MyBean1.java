package copytest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MyBean1 implements Serializable, Cloneable/*implements Cloneable*/ {

    public int num;
    public String str;
    public MyChild1 myChild1;
    public List<MyChild1> list;

    public MyBean1(int num, String str, MyChild1 myChild1) {
        this.num = num;
        this.str = str;
        this.myChild1 = myChild1;
    }

    public void setList(List<MyChild1> list) {
        this.list = list;
    }

    @Override
    protected Object clone() {
        try {
            MyBean1 myBean1 = (MyBean1) super.clone();
            myBean1.myChild1 = (MyChild1) myChild1.clone();

            List<MyChild1> newList = new ArrayList<>();
            for (MyChild1 child1 : list) {
                newList.add((MyChild1) child1.clone());
            }
            myBean1.list = newList;
            return myBean1;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyBean1{" +
                "num=" + num +
                ", str='" + str + '\'' +
                ", myChild1=" + myChild1 +
                '}';
    }
}
