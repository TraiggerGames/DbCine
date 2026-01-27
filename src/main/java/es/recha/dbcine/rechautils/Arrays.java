package rechautils;

public class Arrays {
    public static Object[] expandArray(Object[] arrayToExpand){
        
        return java.util.Arrays.copyOf(arrayToExpand, arrayToExpand.length + 1);

    } 
    public static Object[] expandArray(Object[] arrayToExpand, Object value){
        arrayToExpand = java.util.Arrays.copyOf(arrayToExpand, arrayToExpand.length + 1);
        arrayToExpand[arrayToExpand.length - 1] = value;

        return arrayToExpand;
    } 
    public static Object[][] expandArray(Object[][] arrayToExpand){
        
        return java.util.Arrays.copyOf(arrayToExpand, arrayToExpand.length + 1);

    } 
    public static <T>T[]  expandArray  (T objeto, T[] arrayToExpand ) {
		  arrayToExpand = java.util.Arrays.copyOf(arrayToExpand, arrayToExpand.length + 1);
	        arrayToExpand[arrayToExpand.length - 1] = objeto;
		return arrayToExpand;

	} 
   

}
