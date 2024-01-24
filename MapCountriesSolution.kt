class MapCountriesSolution {

    /**
     * Calculates the number of distinct "countries" in a given map.
     * A "country" is defined as a contiguous area of the same color.
     *
     * The map is represented as a 2D array where each cell's value indicates the color of that area.
     *
     * @param countriesMap The map represented as a 2D array of integers, where each integer corresponds to a color.
     * @return The total number of distinct countries found in the map.
     */
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

    /**
     * A private helper function that uses Depth-First Search (DFS) to explore and mark
     * all areas of the map that are part of the same "country", starting from a given location.
     *
     * A "country" in this context is a contiguous area of the same color on the map.
     *
     * @param array The map represented as a 2D array of integers, each indicating the color of an area.
     * @param visited A 2D boolean array to track which areas have been visited during the search.
     * @param i The current row index in the map to explore.
     * @param j The current column index in the map to explore.
     * @param color The color of the country being explored. This is used to ensure
     *              contiguous areas of the same color are identified as part of the same country.
     */
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
