import java.util.Arrays;

public class NotesArrays {

	public static void main(String[] args) {
		// declare and init 5 int variables
		int x1 = 0, x2 = 1, x3 = 3, x4 = 3;
		// reset their values to 0
		x1 = 0;
		x2 = 0;
		x3 = 0;
		x4 = 0;

		// one-dimensional arrays of primitives!
		// container of same-types!
		int[] array = new int[4]; // create a 1d array to hold 10 ints

		// read from a 1d array - use a specific index!
		System.out.println(array[0]); // indexing

		// query an array for its size (length)
		System.out.println(array.length);

		// writing to the array
		array[0] = 0;
		array[1] = 100;
		array[array.length - 1] = 114514; // access last element
		System.out.println(array[3]);

		/*
		 * Arrays of OBJECTS
		 */

		String[] strObjects = new String[5]; // an array to store String objects
		strObjects[0] = "Hello World";
		System.out.println(strObjects[0]); // empty string is intialized to NULL

		// Common Error: not initializing array objects
		// System.out.println(strObjects[1].length());

		// other ways to initialize 1D arrays!
		int[] newArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(newArray[9]);

		String[] strs2 = { new String("wocaosi"), new String("nide mma") };
		
		
		//invoke the mthod aka call the method
		sayHello();
		
		int val = returnRandomNumber();
		System.out.println(val);
		
		val = returnRandomNumber(10000);
		System.out.println(val);
		
		int[] myArray = new int[15];
		for(int i=0;i<myArray.length;i++) {
			myArray[i] = i;
		}
		
		int sumOfArray = sumArray(myArray);
		System.out.println("sum: "+sumOfArray);
		
		
		int[] reversed = reversedArray(myArray);
		System.out.println(Arrays.toString(reversed));
		for(int element:reversed) {
			System.out.println(element);
		}
		
		
		reversedArrayInPlaced(myArray);
	} //END OF MAIN
	
	// This method will alter the original array
	/*
	 * @param og
	 */
	public static void reversedArrayInPlaced(int[] og) {
		//reverse the array w/o creating a brand new array
		for(int i=0; i<og.length/2;i++) {
			int temp = og[i];
			og[i] = og[og.length-1-i];
			og[og.length-1-i] = temp;
		}
		
		System.out.println("new array"+Arrays.toString(og));
		
	}
	
	
	public static int[] reversedArray(int[] original) {
		int[] res = new int[original.length];
		for(int i =0; i<original.length;i++) {
			res[original.length-1-i] = original[i];
		}
		return res;
	}
	
	
	public static int sumArray(int[] array) {
		int sum = 0;
		for(int item:array) {
			sum+=item;
		}
		return sum;
		
	}
	
	
	public static int returnRandomNumber(int upperBound) {
		return (int)(Math.random()*100);
	}
	
	
	
	public static int returnRandomNumber() {
		return (int)(Math.random()*100);
	}
	
	
	
	
	public static void sayHello(){
		System.out.println("Goodbye world");
	}

}
