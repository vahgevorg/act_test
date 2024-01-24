# Kotlin Solutions for Algorithmic Challenges

## General Overview
This repository contains solutions to two distinct algorithmic challenges, implemented in Kotlin. These challenges include identifying distinct "countries" in a map based on color continuity (Map Countries Solution) and calculating the minimum roof length required to cover a certain number of cars in a parking lot (Parking Dilemma Solution). Both solutions demonstrate efficient use of algorithmic thinking and Kotlin programming capabilities.

## Tech Stack
- **Language**: Kotlin
- **Concepts**: Depth-First Search, Sorting, Sliding Window

---


# Map Countries Solution

## Overview
This `MapCountriesSolution` class contains a Kotlin-based solution to the problem of identifying distinct "countries" in a given map. A country is defined as a contiguous area of the same color on a rectangular map, where connectivity is orthogonal (north, south, east, or west).

## Solution Description
The `MapCountriesSolution` class implements an algorithm to count the number of countries on a given map. The map is represented as a 2D array of integers, where each integer corresponds to a color.

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

---

# Parking Dilemma Solution

## Overview
This Kotlin-based solution addresses the Parking Dilemma problem, where the objective is to find the minimum length of a roof that can cover at least `k` cars in a straight-line parking lot.

## Solution Description
The `getCarParkingRoof` function in this project is designed to calculate the shortest roof length required to cover a specified number of cars, `k`, parked in a parking lot. The parking lot is represented as a linear arrangement of parking spots.

### Functionality
The function `getCarParkingRoof` takes an array of integers representing the positions of parked cars and an integer `k`, denoting the minimum number of cars the roof must cover. It returns the minimum length of the roof that satisfies this requirement.

### Algorithm
The solution is based on sorting the positions of cars and then sliding a window of size `k` along the sorted positions to find the minimum distance that can cover `k` cars.

#### Approach
- **Sorting**: The array of car positions is sorted to organize the cars in increasing order of their positions.
- **Sliding Window**: A window of size `k` is slid through the sorted positions to calculate the length needed to cover `k` consecutive cars. The minimum of these lengths is determined to be the solution.

### Usage
The function can be directly invoked with the array of car positions and the number `k` as arguments. For instance, `getCarParkingRoof(intArrayOf(6, 2, 12, 7), 3)` would return the minimum length of the roof required to cover at least 3 cars.

## Constraints
- The number of cars `n` is within the range 1 to 100,000.
- The number of cars to be covered `k` is within the range 1 to `n`.
- Car positions are unique integers within the range 1 to 1,000,000,000,000,000.

## Testing
The solution has been tested with various scenarios to ensure its correctness and efficiency, especially under the constraint boundaries. It is recommended to perform additional testing with diverse sets of input for robust validation.
