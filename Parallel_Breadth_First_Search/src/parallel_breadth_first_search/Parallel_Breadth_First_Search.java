
package parallel_breadth_first_search;

import java.util.Calendar;

/**
 *
 * @author Mariam,  Nehal,  Nada
 */
public class Parallel_Breadth_First_Search {

   
    public static void main(String[] args) {
        
        long start, finish;
		final int  numberOfNodes = 5000;
		final int numberOfCore = 4;
		
		boolean[] visited = new boolean[numberOfNodes];
		for(int i = 0; i<numberOfNodes; i++){
			visited[i] = false;
		}
		Graph graph = new Graph(numberOfNodes,visited,numberOfCore);
		/**
		 * Parallel BFS 
		 * */
		start = Calendar.getInstance().getTimeInMillis();
		Thread[] processors = new PBFS[numberOfCore];
		for(int i = 0; i<numberOfCore; i++){
			processors[i] = new PBFS(graph,i);
			processors[i].start();
		}
		for(int i = 0; i<numberOfCore; i++){
			try {
				processors[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		finish = Calendar.getInstance().getTimeInMillis();
		System.out.println("Parallel Time "+(finish-start)); 
		boolean success = true;
		for(int i = 0;i<numberOfNodes;i++){
			if(!visited[i]){
				success = false;
				System.out.println("Failure");
				break;
			}
		}
		if(success)
			System.out.println("Success ");
		/**
		 * Serial BFS 
		 * */
		for(int i = 0;i<numberOfNodes;i++){
			visited[i] = false;
		}
                
		start = Calendar.getInstance().getTimeInMillis();
		serialBFS serialBfs = new serialBFS(numberOfNodes, visited, numberOfNodes-1);
		
                serialBfs.run();
		finish = Calendar.getInstance().getTimeInMillis();
		System.out.println("Serial Time "+(finish-start)); 
		success = true;
		for(int i = 0;i<numberOfNodes;i++){
			if(!visited[i]){
				success = false;
				System.out.println("Failure");
				break;
			}
		}
		if(success)
			System.out.println("Success ");
    }
    
}
