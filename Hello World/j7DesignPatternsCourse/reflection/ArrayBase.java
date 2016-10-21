package j7DesignPatternsCourse.reflection;

import java.lang.reflect.Array;

public abstract class ArrayBase
{
	//The number of values currently present in the array.
	protected int countPresent;
	
	//Size of the current array.
	protected int countLimit;
	
	//Maximum size increment for growing array.
	protected int maximumGrowth;
	
	//Constructor with full specification.
	//Start size, Max size and the type allowed in this
	//collection
	public ArrayBase(int size, int growth, Class type) {
		Object array = Array.newInstance(type, size);
		countLimit = size;
		maximumGrowth = growth;
		setArray(array);
	}
	
	//Constructor with partial specification.
	//Start size and the type allowed in this collection
	public ArrayBase(int size, Class type) {
		this(size, Integer.MAX_VALUE, type);
	}
	
	//ABSTRACT METHODS ? MUST BE IMPLEMENTED IN DERIVED CLASSES
	//Get the backing array. This method is used by the type-agnostic base
	//class code to access the array used for type-specific storage by the
	//child class.
	protected abstract Object getArray();
	
	//Set the backing array. This method is used by the type-agnostic base
	//class code to set the array used for type-specific storage by the
	//child class.
	protected abstract void setArray(Object array);
	
	//Discards values for a range of indices from the array. 
	//This method mustbe overridden by the subclass to set the
	//corresponding array elements to
	//the appropriate default value.
	protected abstract void discardValues(int from, int to);
	
	//Increase the size of the array to at least a specified size. The array
	//will normally be at least doubled in size, but if a maximum size
	//increment was specified in the constructor and the value is less than
	//the current size of the array, the maximum increment will be used
	//instead. If the requested size requires more than the default growth, 
	//the requested size overrides the normal growth and determines the size
	//of the replacement array.
	protected void growArray(int required) {
		Object base = getArray();
		int size = Math.max(required,
				countLimit + Math.min(countLimit, maximumGrowth));
		Class type = base.getClass().getComponentType();
		Object grown = Array.newInstance(type, size);
		System.arraycopy(base, 0, grown, 0, countLimit);
		countLimit = size;
		setArray(grown);
	}
	
	//Ensure that the array has the capacity for at least the specified
	//number of values.
	public void ensureCapacity(int min) {
		if (min > countLimit) {  growArray(min);  }
	}
	
	//Gets the next add position for appending a value to those in the array
	//If the underlying array is full, it is grown by the appropriate size
	//increment so that the index value returned is always valid for the 
	//array in use by the time of the return.
	protected int getAddIndex() {
		int index = countPresent++;
		if (countPresent > countLimit) {  growArray(countPresent); }
		return index;
	}
	
	//Makes room to insert a value at a specified index in the array.  
	protected void makeInsertSpace(int index) {
		if (index >= 0 && index <= countPresent) {
			if (++countPresent > countLimit) {
				growArray(countPresent);
			}
			if (index < countPresent - 1) {
				Object array = getArray();
				System.arraycopy(array, index, array, index + 1,
						countPresent - index - 1);
			}
		} else { throw new ArrayIndexOutOfBoundsException("Invalid index"); }
	}
	
	//Remove a value from the array. All values above the index removed
	//are moved down one index position
	public void remove(int index) {
		if (index >= 0 && index < countPresent) {
			if (index < --countPresent){
				Object base = getArray();
				System.arraycopy(base, index + 1, base, index,
						countPresent - index);
				discardValues(countPresent, countPresent + 1);
			}
		} else {
			throw new ArrayIndexOutOfBoundsException("Invalid index value");
		}
	}
	
	//Get the number of values currently present in the array.
	public int size() {
		return countPresent;
	}
	
	//Sets the number of values currently present in the array. If the new
	//size is greater than the current size, the added values are init.
	//to the default values. If the new size is less than the current size,
	//all values dropped from the array are discarded.
	public void setSize(int count) {
		if (count > countLimit) {  growArray(count); } 
		else if (count < countPresent){ discardValues(count, countPresent); }
		countPresent = count;
	}
	
	//Set the array to the empty state.
	public void clear() {
		setSize(0);
	}

	//Constructs and returns a simple array containing the same data as
	//held in this growable array.
	//This method receives type element type for constructed array
	protected Object buildArray(Class type) {
		Object copy = Array.newInstance(type, countPresent);
		System.arraycopy(getArray(), 0, copy, 0, countPresent);
		return copy;
	}
}


