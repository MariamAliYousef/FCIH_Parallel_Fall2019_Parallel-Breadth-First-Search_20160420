# FCIH_Parallel_Fall2019_Parallel-Breadth-First-Search_20160240

The breadth first search algorithm: is a way to explore the vertexes of a graph layer by layer.

Serial breadth first search: 
In the sequential BFS algorithm, 2 data structures are created to store the frontier and the next frontier. 
The frontier contains the vertexes that have the same distance("level") from the source vertex, these vertexes need to explored in BFS. 
The next frontier contains the vertexes that are not discovered yet and will be discovered. 
  
There are some issues in this simple way. 
  
Parallel breadth first search: 
- A neighbour for any vertex can also be the neighbour for another vertex in the frontier. 
- The distance of this node can be updated more than one time. 
- These races waste resources and lead to unnecessary overhead. 

Team names:
- Mariam Ali Yousef   => 20160420
- Nehal Adel Mohamed  => 2016476
- Nada Ali Ebrahim    => 20160468
