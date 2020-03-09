/**
* The following algorithm calculates a median of two sorted arrays of the same size.
* Time complexity: O(log n)
* @author Amanda Olearczuk
* @date March 2020
*/
import java.util.*; 
class Main { 

    public static void main(String[] args) 
    { 
        double a1[] = { 2, 6, 7 ,11}; 
        double a2[] = { 1, 8, 9 ,10 }; 
        int a1_len = a1.length; 
        int a2_len = a2.length; 
 
        double median = getMedian(a1, a2, 0, a1_len - 1,0, a2_len - 1);
        System.out.println("Median is "+ median); 
        
    }
  
static double getMedian(double[] a, double[] b, int startA, int endA, int startB, int endB) 
    { 

      // Base case - Arrays have 1 element each
      if(endA-startA==0){ 
        return (a[0]+b[0])/2;
      }
      //Base case - Arrays have 2 elements each 
      else if (endA - startA == 1 && endB - startB == 1) { 
            return (Math.max(a[startA],b[startB])+ Math.min(a[endA], b[endB]))/ 2; 
      } 

      // get the medians of first and second array
        double m1 = median(a, startA, endA); 
        double m2 = median(b, startB, endB); 
        
      //Get the middle value index for even length arrays
        int mid_a_even = (endA - startA+1)/2 +startA ;
        int mid_b_even = (endB - startB+1)/2 +startB;

      //Get the middle value index for odd length arrays
        int mid_a_odd = (endA-startA)/2 + startA;
        int mid_b_odd = (endB-startB)/2 + startB;

       //Medians are equal - no need to continue.
        if (m1 == m2) { 
            return m1; 
        } 

        //if m1 < m2 then median must exist in second half of a first half of b.
        else if (m1 < m2) {
           if((endA - startA +1) % 2 == 1){//Arrays are odd numbered
               return getMedian(a, b, mid_a_odd,endA, startB,mid_b_odd); 
           } 
           else{ // Arrays are even numbered
             return getMedian(a, b, mid_a_even-1,endA, startB,mid_a_even); 
            }
            
        } 
  
      //if m1 > m2 then median must exist in first half of a and second half of b 
        else { 

          if((endA - startA+1) % 2 == 1){ // Arrays are odd numbered
            return getMedian(a, b, startA, mid_a_odd ,mid_b_odd,endB); 
          } 
          else{ //Arrays are even numbered
            return getMedian(a, b, startA, mid_a_even ,mid_a_even-1,endB); 
          } 

        }
    } 
  
    static double median(double[] a, int start, int end) 
    { 
        int a_len = end - start + 1; 
        if (a_len % 2 == 0) { //Array has even length
            return (a[start + (a_len / 2)]+ a[start + (a_len-1) / 2 ])/ 2; 
        } 
        else { //Array has odd length
            return a[start + (a_len-1) / 2]; 
        } 

    } 
  
  
} 
