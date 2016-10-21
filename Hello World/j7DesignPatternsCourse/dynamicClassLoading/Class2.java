package j7DesignPatternsCourse.dynamicClassLoading;

public class Class2
{
    static {
        System.out.println("Class2 was loaded");
    }
    
    public Class2()
    {
        System.out.println("In Class2 constructor");
    }

    public void go()
    {
        System.out.println("I\'m " + this.toString());
    }
}
