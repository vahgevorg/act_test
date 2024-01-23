package com.unlimitedbiking.micromobility.ui

class MapCountriesSolution {

    // Function to count the number of countries in the given map
    fun getCountriesCount(countriesMap: Array<IntArray>): Int {
        val n = countriesMap.size // Number of rows in the map
        val m = countriesMap[0].size // Number of columns in the map
        var countries = 0 // Counter for the number of countries
        val visited = Array(n) { BooleanArray(m) } // Matrix to keep track of visited areas

        // Iterating through each area in the map
        for (i in 0 until n) {
            for (j in 0 until m) {
                // Check if the current area is already part of a counted country
                if (!visited[i][j]) {
                    // Perform a depth-first search from this area
                    exploreCountriesUsingDFS(countriesMap, visited, i, j, countriesMap[i][j])
                    countries++ // Increment the count of countries
                }
            }
        }
        return countries // Return the total number of countries
    }

    // Depth-First Search function to explore the map
    private fun exploreCountriesUsingDFS(array: Array<IntArray>, visited: Array<BooleanArray>, i: Int, j: Int, color: Int) {
        // Check for boundary conditions and if the area is already visited or not the same color
        if (i < 0 || i >= array.size || j < 0 || j >= array[0].size || visited[i][j] || array[i][j] != color) {
            return
        }

        // Mark the current area as visited
        visited[i][j] = true

        // Recursively visit all adjacent areas (up, down, left, right)
        exploreCountriesUsingDFS(array, visited, i - 1, j, color) // up
        exploreCountriesUsingDFS(array, visited, i + 1, j, color) // down
        exploreCountriesUsingDFS(array, visited, i, j - 1, color) // left
        exploreCountriesUsingDFS(array, visited, i, j + 1, color) // right
    }
}