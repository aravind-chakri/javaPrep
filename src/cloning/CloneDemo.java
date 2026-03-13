package cloning;

public class CloneDemo implements Cloneable{

    int a;
    int b;

    public CloneDemo(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneDemo demo = new CloneDemo(10, 20);


        CloneDemo obj2 = (CloneDemo) demo.clone();

        System.out.println("a: " + demo.a + " b: " + demo.b);
        System.out.println("a: " + obj2.a + " b: " + obj2.b);
        System.out.println(demo == obj2);
        obj2.b = 30;
        demo.a = 100;
        System.out.println("a: " + demo.a + " b: " + demo.b);
        System.out.println("a: " + obj2.a + " b: " + obj2.b);

    }
}
