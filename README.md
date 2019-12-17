# FCIH_Parallel_Fall2019_Parallel-Breadth-First-Search_20160420

The breadth first search algorithm: is a way to explore the vertexes of a graph layer by layer.

Serial breadth first search: 
In the sequential BFS algorithm, 2 data structures are created to store the frontier and the next frontier. 
The frontier contains the vertexes that have the same distance("level") from the source vertex, these vertexes need to explored in BFS. 
The next frontier contains the vertexes that are not discovered yet and will be discovered. 
  
There are some issues in this simple way:
   
- A neighbour for any vertex can also be the neighbour for another vertex in the frontier. 
- The distance of this node can be updated more than one time. 
- These races waste resources and lead to unnecessary overhead. 

Synchronization  is needed.

Parallel Breadth first search:
- Synchronization is necessary after each layer traversal to ensure the correctness of parallel BFS.
- Load balancing for neighbour dicovering. Because there is a synchronization after each layer-traversal, every processing entity must wait until the last of them finish its work. Therefore, the parallel entity which has the most neighbors decides the time consumption of this layer. With the optimization of load-balancing, the time of layer-traversal can be reduced.

Team names:
- Mariam Ali Yousef   => 20160420
- Nehal Adel Mohamed  => 20160476
- Nada Ali Ebrahim    => 20160468
