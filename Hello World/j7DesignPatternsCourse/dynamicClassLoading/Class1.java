package j7DesignPatternsCourse.dynamicClassLoading;

public class Class1
{
    static {
        System.out.println("Class1 was loaded");
    }
    
    public Class1()
    {
        System.out.println("In Class1 constructor");
    }

    public void go()
    {
        System.out.println("I\'m " + this.toString());
    }
}
