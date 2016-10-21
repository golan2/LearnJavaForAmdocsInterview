package j7DesignPatternsCourse.reflection;

public class IntBaseArray extends ArrayBase
{
  //The underlying array used for storing the data.
  protected int[] baseArray;
  
  //Constructor with full specification.  
  public IntBaseArray(int size, int growth) {
    super(size, growth, Integer.TYPE); //Well, here we do know the type.
  }
  
  //Constructor with only initial size specified.
  public IntBaseArray(int size) {
    super(size, Integer.TYPE); //Again, the type is known.
  }
  
  //Get the backing array. This method is used by the type-agnostic base
  //class code to access the array used for type-specific storage.
  protected Object getArray() {
    return baseArray;
  }
  
  //Set the backing array. This method is used by the type-agnostic base
  //class code to set the array used for type-specific storage.
  protected void setArray(Object array) {
    baseArray = (int[]) array;
  }
  
  //Discards values for a range of indices from the array. For the array
  //of int values, just sets the values to 0.  
  protected void discardValues(int from, int to) {
    for (int i = from; i < to; i++) {
      baseArray[i] = 0;
    }
  }
  
  //Add a value to the array, appending it after the current values.
  public int add(int value) {
    int index = getAddIndex();
    baseArray[index] = value;
    return index;
  }
  
  //Add a value at a specified index in the array.
  public void add(int index, int value) {
    makeInsertSpace(index);
    baseArray[index] = value;
  }
  
  //Retrieve the value present at an index position in the array.  
  public int get(int index) {
    if (index < countPresent) {  return baseArray[index];  } 
    else { throw new ArrayIndexOutOfBoundsException("Invalid index");  }
  }
  
  //Set the value at an index position in the array.
  public void set(int index, int value) {
    if (index < countPresent) { baseArray[index] = value; } 
    else {
      throw new ArrayIndexOutOfBoundsException("Invalid index value");
    }
  }
  
  //Constructs and returns a simple array containing the same data
  //in this growable array.
  public int[] toArray() { 
	  return (int[]) buildArray(Integer.TYPE); 
	  }
  
  //Duplicates the object with a type-safe return.
  public IntBaseArray duplicate() {
    IntBaseArray clone = new IntBaseArray(baseArray.length);
    System.arraycopy(baseArray, 0, clone.baseArray, 0, countPresent);
    clone.countPresent = countPresent;
    return clone;
  }
  
  public Object clone() {
    return duplicate();
  }
}
