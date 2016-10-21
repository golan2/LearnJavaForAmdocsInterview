package General;
/*
 * Created on 04/12/2005
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */


public interface IBullshit {
	
	int n1=1;
	public int f1();
}

interface IBullshit2 extends IBullshit {
	
	int n2=1;
	public int f2();
}

class Bulshit_a implements IBullshit2
{
	public int f1()
	{
		return 1;
	}
	public int f2()
	{
		return 2;
	}
}

interface INonesense 
{
	int n3=1;
	public int f3();
}

interface IBulshit3 extends IBullshit,INonesense
{
}

class Bulshit_b extends Bulshit_a implements IBulshit3
{
	public int f3()
	{
		return 3;
	}
}
