import java.util.ArrayList;
import java.util.Stack;


public class Solutiont {

		public int largestRectangleArea(ArrayList<Integer> a) {
		    if(a.size()==1) return a.get(0);
		    Stack<Integer> s1 = new Stack<>();
		    s1.push(0);
		    int minIndex=0;
		    int area=0;
		    int maxArea=Integer.MIN_VALUE;
		    for(int i=1;i<a.size();i++){
		        if(a.get(s1.peek())<=a.get(i)){
		            s1.push(i);
		        }else{
		            int top =s1.peek();
		            s1.pop();
		            int left=0;
		            if(s1.isEmpty()){
		                left=i;
		            }
		            else{
		                left=i-s1.peek()-1;
		            }
		            area=a.get(top)*left;
		            maxArea=Math.max(area,maxArea);
		        }
		        
		    }
		   ArrayList<Integer> t= new ArrayList<Integer>();
		   StringBuffer st = new StringBuffer();
		   //st.deleteCharAt(index)
		    return maxArea;
		   
		}
	}

