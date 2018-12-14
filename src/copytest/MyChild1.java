package copytest;

import java.io.Serializable;

public class MyChild1 implements Serializable,Cloneable /*implements Cloneable*/ {

    public int num;
    public String str;

    public MyChild1(int num, String str) {
        this.num = num;
        this.str = str;
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "MyChild1{" +
                "num=" + num +
                ", str='" + str + '\'' +
                '}';
    }
}
