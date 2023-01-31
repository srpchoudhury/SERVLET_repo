package com.nt.test;

public class DynaObjectTest1 {
      public static void main(String[] args) {
    	  try {
		//load java class
    		  Class c=Class.forName(args[0]);
    		 //create dynamic object
    		  Object obj=c.newInstance();
    		  System.out.println(obj);
    	  }
    	  catch(Exception e) {
    		  e.printStackTrace();
    	  }
    	  
	}
}
