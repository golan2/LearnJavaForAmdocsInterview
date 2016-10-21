package j7DesignPatternsCourse.dynamicClassLoading;

public class Class3
{
    static {
        System.out.println("Class3 was loaded");
    }
    
    public Class3()
    {
        System.out.println("In Class3 constructor");
    }

    public void go()
    {
        System.out.println("I\'m " + this.toString());
    }
}
