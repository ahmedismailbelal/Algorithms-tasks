package p4;
import java.util.Scanner;
import java.util.Vector;

public class clear {
   
   public static int Counter=0;
   
   public  Vector<Integer> makeNewArray(int array[]) {
	   
	   Vector<Integer> newArray=new Vector<Integer>();
	   
	   for(int i=0;i<array.length;i++) {
		   for(int j=0;j<array[i];j++) {
			   newArray.add(i+1);
		   }
	   }
	   return newArray;
   }
  
   public Vector<Integer> Op1(int array[]) {
	   Vector<Integer> newArray=  makeNewArray(array);
	   System.out.print("Your new Array : ");
	   
	   for(int i=0 ; i< newArray.size(); i++) 
	   {
		   System.out.print(newArray.get(i)+" ");
	   }
	   
	   for(int i=1 ; i<array.length+1 ; i++) {
		   
		   int currentIndex = newArray.indexOf(i);
		   
		   if(currentIndex>=0)
		   {
			   newArray.remove(currentIndex);
		   }
		   else 
		   {
			   Counter++;
		   }//1
		   
	   }
	   System.out.println();  
	   System.out.print("operation number 1 : ");
	   
	   for(int i=0 ;i <newArray.size() ; i++) 
	   {
		   System.out.print(newArray.get(i)+" ");
		   
	   }
	   Counter++;
	   return newArray;  
   }
	private int Frequancy(int number,Vector<Integer> newArray) {
		 int Freqq = 0;  
		 
		 if(newArray.size()==1) 
		 {
			 Freqq=1;
		 }
		 else {
			for(int i = 0; i < newArray.size(); i++){  
	                if(number == newArray.get(i)){
	                	
	                    Freqq++;  
	            }
            
		}
		}
		
		return Freqq;
	}
	
	private Vector<Integer> clearTheMultiset (Vector<Integer>newarray) {
		
		  int freq=Frequancy(newarray.get(0),newarray);
		   
		  // System.out.print(freq);
		   
	      for(int i=freq-1;i>=0;i--)
		      {
	    	  
	    	  	newarray.remove(i);
	    	  }
      	  if(!newarray.isEmpty())
		      {
      		  	
      		  	Counter++;
      		  	clearTheMultiset(newarray);
      		  	
      		  }
		    //  System.out.print(newarray);
		      return newarray;
	}
	public void Op2(int array[]){
		Vector<Integer> newArray=new Vector<Integer>();
	    Vector<Integer> newArray1=Op1(array);
	    if(!newArray1.isEmpty()) {
	    	  Counter++;
	    	  newArray=clearTheMultiset(newArray1);
	    	   
	    }
	    System.out.println(); 
	    
	    System.out.print("operation number 2 : ");
	    
	    for(int i=0;i<newArray.size();i++)   
	    {
	    	
		  System.out.print(newArray.get(i)+" ");
		  
	    }
	  
	    System.out.println(); 
      
        }
	    
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter you array's size"); 
		int n  = in.nextInt();
		int arr [] = new int[n];
		System.out.println("Enter you numbers");
		for (int i = 0 ; i < n ; i++)
		{
			
			int num = in.nextInt();
			arr[i] = num ;
		}
		
		clear l=new clear();
		
		l.Op2(arr);
		
		System.out.print("counter = "+Counter);
	}
}