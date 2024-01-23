# Map Countries Solution

## Overview
This project contains a Kotlin-based solution to the problem of identifying distinct "countries" in a given map. A country is defined as a contiguous area of the same color on a rectangular map, where connectivity is orthogonal (north, south, east, or west).

## Solution Description
The `MapCountriesSolution` class in this project implements an algorithm to count the number of countries on a given map. The map is represented as a 2D array of integers, where each integer corresponds to a color.

### Algorithm
The core algorithm uses Depth-First Search (DFS) to explore the map. DFS is chosen for its efficiency in traversing connected components in a graph-like structure, which in this case, are the contiguous areas of the same color on the map.

#### Why DFS?
- **Memory Efficiency**: DFS is more memory-efficient compared to Breadth-First Search (BFS), especially considering the constraint that the total number of elements in the matrix does not exceed 300,000. This reduces the likelihood of memory-related issues.
- **Depth Handling**: Given the constraints, the maximum depth of DFS is manageable, thus minimizing the risk of stack overflow.
- **Simplicity**: DFS implementation is generally simpler and more straightforward, particularly when dealing with scenarios where the shortest path is not a requirement.

### Methodology
The solution iterates over each cell in the map. If a cell is part of an unexplored country, DFS is initiated from that cell to mark all connected areas of the same color. Each initiation of DFS signifies the discovery of a new country, and thus the country counter is incremented.

### DFS Implementation
DFS is implemented as a recursive function `exploreCountriesUsingDFS`. It checks each neighboring cell (up, down, left, right) and recursively explores further if the neighbor is of the same color and unvisited. This process continues until all areas of a particular country have been visited.

## Usage
The main functionality can be accessed through the `getCountriesCount` method of the `MapCountriesSolution` class, which takes a 2D integer array as input and returns the number of countries.

## Testing
The solution has been tested with various input scenarios to ensure correctness and efficiency. It is advisable to perform additional testing with edge cases and large datasets for comprehensive validation.

## Scalability and Future Enhancements
While the current solution is optimized within the specified constraints, future enhancements could include:
- Implementing iterative DFS to handle deeper recursion levels.
- Adding more comprehensive error handling and input validation.
