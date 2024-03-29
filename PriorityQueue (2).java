package trail2;

//package hospitalmanagement;
import java.util.*;
import java.util.Collections;
public class PriorityQueue {
     Patient[] arrqueue;
     int size=-1;
     int front;
     int end;
     PriorityQueue(){
    	 this.arrqueue=new Patient[20];
     }
     public void insert(Patient person) { //time complexity 0(log(n))
    	 arrqueue[++size]=person;
    	 if(size==0) {
    		 //System.out.print(size);
    		 return;
    	 }
    	 
    	 int i=size;
    	 while(i>0) { 
    	  if(person.priority<=arrqueue[ (i-1)/2].priority){
    		  //System.out.print(size);
    		  i=0;
    		  return;
    	 }
    	  else {
    		  swap1(arrqueue[(i-1)/2],arrqueue[i]);
    		  swap((i-1)/2,i);
    		  
    		  i=(i-1)/2;
    		  
    		  //System.out.print(size+" "+i);
    		  
    	  }
    	  
    	  
     }
    	 
     }
     boolean isEmpty() {
    	 return size<0;
     }
     
     public void dequeue() {
    	 if(isEmpty()) {
    		 return;
    	 }
    	 swap(0,size);
    	 int j=0;
    		 size--;
    		 while(2*j+2<=size) {
//    			 if(2*j+2>size) {
//     				return;
//     			}
    			if(arrqueue[0].priority>arrqueue[2*j+1].priority && arrqueue[0].priority>arrqueue[2*j+2].priority) {
    				return;
    			}
    			
    			else {
    				if(2*j+2<=size) {
    				if(arrqueue[2*j+1].priority<=arrqueue[2*j+2].priority) {
    					swap(j,2*j+2);
    					j=2*j+2;
    					
    				}
    				else {
    					swap(j,2*j+1);
    					j=2*j+1;
    				}
    				}
    				else {
    					swap(j,2*j+1);
    					j=2*j+1;
    				}
    				
    				
    			}
    		 }
         
    	 
     }
     boolean isfull() {
    	 
    	 return size==arrqueue.length-1;
     }
     Patient peek() {
    	 if (size<0) {
    		 return null;
    	 }
    	 
    	 return arrqueue[0];
     }
     private void swap(int i, int j)                

     {
//    	 Date dateI = arrqueue[i].getDateAndTime();
//    	    Date dateJ = arrqueue[j].getDateAndTime();
//
//    	    // Swap the Date objects between the Patient objects
//    	    arrqueue[i].setDateAndTime(dateJ);
//    	    arrqueue[j].setDateAndTime(dateI);
          Patient temp = arrqueue[i];
          
          arrqueue[i] = arrqueue[j];

          arrqueue[j] = temp;

      }
     private void swap1(Patient i, Patient j) {
    	    Date dateI = i.getDateAndTime();
    	    Date dateJ = j.getDateAndTime();

    	    // Swap the Date objects between the Patient objects
    	    i.setDateAndTime(dateJ);
    	    j.setDateAndTime(dateI);
    	}
     Patient bottom() {
    	 if (size<0) {
    		 return null;
    	 }
    	 
    	 return arrqueue[size];}
     
     
//     private void swap1(int i, int j) {
//    	    Date dateI = arrqueue[i].getDateAndTime();
//    	    Date dateJ = arrqueue[j].getDateAndTime();
//
//    	    // Extract the hours and minutes from the Date objects
//    	    int hoursI = dateI.getHours();
//    	    int minutesI = dateI.getMinutes();
//    	    int hoursJ = dateJ.getHours();
//    	    int minutesJ = dateJ.getMinutes();
//
//    	    // Create new Date objects with swapped hours and minutes
//    	    Date newDateI = new Date(dateI.getYear(), dateI.getMonth(), dateI.getDate(), hoursJ, minutesJ);
//    	    Date newDateJ = new Date(dateJ.getYear(), dateJ.getMonth(), dateJ.getDate(), hoursI, minutesI);
//
//    	    // Set the updated Date objects to the respective elements
//    	    arrqueue[i].setDateAndTime(newDateI);
//    	    arrqueue[j].setDateAndTime(newDateJ);
//    	}
     
}