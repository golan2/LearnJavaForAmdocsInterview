package j7DesignPatternsCourse.dynamicClassLoading;



public class Main
{
    public static void go()
    {	
        System.out.println("In Main before Instantiating Class 1");
        Class1 c1 = new Class1();
        c1.go();
        System.out.println("In Main after Instantiating Class 1");
        
        System.out.println("In Main before Instantiating Class 2");
        Class2 c2 = new Class2();
        c2.go();
        System.out.println("In Main after Instantiating Class 2");
        
        System.out.println("In Main before Instantiating Class 3");
        Class3 c3 = new Class3();
        c3.go();
        System.out.println("In Main after Instantiating Class 3");
        
        System.out.println("Done");
    }
}

