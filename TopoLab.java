package topologicalSort;
import java.io.*;
import java.util.ArrayList;

class Vertex {
   private  String name;                    
   private ArrayList<Vertex> outgoing;  // This list stores the "destination" vertex of a "source" vertex
   
   //is node visited or not
   private boolean visited;
   
   //this segment modifies the visited variable of the vertex to be true or not depending on input from user
   public void setVisited(boolean b){
	   if(b)
		   visited = true;
	   else
		   visited = false;
   }
   //accessor for visited value
   public boolean getVisited(){
	   return visited;
   }
   
   public Vertex(String argName) 
   {
	   name = argName;
	   outgoing = new ArrayList<Vertex>();   
   }
   
   public String getName() // returns the name of the vertex, not its index
   {
      return name;
   }
   
   // Returns the list that stores the "destination" vertices of the "source" vertex
   // Accessor of instance variable adjacencies
   public ArrayList<Vertex> getOutgoing() 
   {
      return outgoing;
   }
   public void setOutgoing(Vertex v){
	   outgoing.add(v);
   }
   
   //additional pieces for topological sorting
    
//   //returns the indegree of the vertex
//   public int getIn(){
//	   return inDegree;
//   }
//   public void setIn(){
//	   inDegree++;
//   }
}  // end of Vertex

public class TopoLab {
	
	private String sorted;
	ArrayList<Vertex> vertices;
	
	public TopoLab(ArrayList<Vertex> vert){
		sorted = "";
		vertices = vert;
	}
	//calculates if there are still inDegrees left to check
	private int inTotal(int[] input){
		int count = 0;
		for(int i : input){
			count = count + i;
		}
		return count;
	}
	public int vertToIndex(Vertex v){
		for(int i = 0; i < vertices.size(); i++){
			if(vertices.get(i).getName().equals(v.getName()))
				return i;
		}
		return 0;
	}
	//sorts the inputted in array
	public void topoSortArray(int[] input){
		//while the inDegrees are not all zero, having nodes still available
		while(inTotal(input) > 0){
			for(int i = 0; i < input.length; i++){
				if(input[i] == 0 && vertices.get(i).getVisited() == false){
					vertices.get(i).setVisited(true);
					for(Vertex v: vertices.get(i).getOutgoing()){
						input[vertToIndex(v)] = input[vertToIndex(v)]--;
					}
				}
			}
		}
		
		
		
		
		
		
		
		
		
		
		
//		while(inTotal(input) > 0){
//			//for each number in the inDegree array
//			for(int i = 0; i < input.length; i++){
//				//if the inDegree is 0
//				if(input[i] == 0 && vertices.get(i).getVisited() == false){
//					sorted = sorted + " " + vertices.get(i).getName();
//					vertices.get(i).setVisited(true);
//					//while the node has outgoing nodes
//					if(vertices.get(i).getOutgoing() != null){
//						//for each outgoig node, remove one from that inDegree
//						for(Vertex v : vertices.get(i).getOutgoing()){
//							input[vertToIndex(v)] = input[vertToIndex(v)] - 1;
//						}
//					}
//				}
//			}
//		}
	}
	public String toString(){
		return sorted;
	}
}
