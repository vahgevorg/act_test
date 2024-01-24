package com.unlimitedbiking.micromobility.ui

class ParkingDilemmaSolution {

    /**
     * Determines the minimum length of the roof needed to cover at least 'k' cars in a parking lot.
     *
     * @param cars An array representing the parking spots occupied by cars.
     * @param k The minimum number of cars that need to be covered by the roof.
     * @return The minimum length of the roof that can cover 'k' cars.
     */
    fun getCarParkingRoof(cars: IntArray, k: Int): Int {
        // Sort the array of car positions
        cars.sort()

        // Initialize the minimum length to a very large number
        var minRoofLength = Int.MAX_VALUE

        // Loop through the array and find the minimum length
        for (i in 0 until cars.size - k + 1) {
            // Calculate the length of the roof for current set of k cars
            val currentRoofLength = cars[i + k - 1] - cars[i] + 1

            // Update the minimum roof length if current is smaller
            minRoofLength = minOf(minRoofLength, currentRoofLength)
        }

        return minRoofLength
    }
}