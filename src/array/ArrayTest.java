package array;

import java.util.ArrayList;

public class ArrayTest {

    public static void main(String[] args) {
        // with Arraylist, 
        // We just invoking regular old methods on a regular old object
        // using the regular old dot operator
        arrayListTest();
        System.out.println("=====");

        // with an array,you use special array syntax( myList[0] = "foo") 
        // that you won't use anywhere else except arrays
        // even though an array is an object, it lives in its own special world.
        regularArrayTest();
    }

    public  static  void arrayListTest(){
        ArrayList<String> myList = new ArrayList<>();

        String a = "whoohoo";
        myList.add(a);

        String b = "Forg";
        myList.add(b);
        
        int size = myList.size();
        System.out.println("size is " + size);

        String str = myList.get(1);
        System.out.println("second str is " + str);

        System.out.println("remove the second item");
        myList.remove(1);

        boolean isIn = myList.contains(b);
        System.out.println("now the list contains the second str is " + isIn);

        int newSize = myList.size();
        System.out.println("the new size of myList is " +  newSize);


    }

    public static void regularArrayTest(){
        String[] myList = new String[2];

        String a = "whoohoo";
        myList[0] = a;

        String b = "Forg";
        myList[1] = b;
        
        int size = myList.length;
        System.out.println("size is " + size);

        String str = myList[1];
        System.out.println("second str is " + str);

        System.out.println("remove the second item");
        myList[1] = null;

        boolean isIn = false;
        for(String item : myList){
            if(b.equals(item)){
                isIn = true;
                break;
            }
        }
        System.out.println("now the list contains the second str is " + isIn);


        int newSize = myList.length;
        System.out.println("the new size of myList is " +  newSize);
    }

        
}
