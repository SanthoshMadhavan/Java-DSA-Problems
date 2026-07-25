# Best Time to Buy and Sell Stock

## Problem

You are given an array `prices` where `prices[i]` represents the stock price on the `i-th` day.

You can buy the stock on one day and sell it on a later day.

Return the maximum profit you can achieve.

If you cannot make any profit, return `0`.

### Important Rule

You must buy before you sell.

---

## Examples

### Example 1

Input: `prices = [7, 1, 5, 3, 6, 4]`

Output: `5`

Explanation:

Buy at price `1` and sell at price `6`.

Profit = `6 - 1 = 5`

---

### Example 2

Input: `prices = [7, 6, 4, 3, 1]`

Output: `0`

Explanation:

The prices keep decreasing, so there is no profitable transaction.

---

### Example 3

Input: `prices = [2, 4, 1, 7]`

Output: `6`

Explanation:

Buy at price `1` and sell at price `7`.

Profit = `7 - 1 = 6`

---

## Approach

We solve this problem using a **Greedy / One-Pass** approach.

The main idea is to keep track of two things while traversing the array:

- `minPrice` → the lowest stock price seen so far.
- `maxProfit` → the maximum profit found so far.

For every price, we calculate:

`profit = current price - minPrice`

Then update `maxProfit` if the current profit is greater.

### Why this works

Suppose:

`prices = [7, 1, 5, 3, 6, 4]`

When we reach `5`, the cheapest price seen before it is `1`.

So:

`profit = 5 - 1 = 4`

When we reach `6`:

`profit = 6 - 1 = 5`

Therefore, the best profit is `5`.

We don't need to check every possible buy and sell combination.

We only need:

`minPrice` → cheapest price so far

`maxProfit` → best profit so far

---

## Step-by-Step Dry Run

Input:

`prices = [7, 1, 5, 3, 6, 4]`

Initial values:

`minPrice = Integer.MAX_VALUE`

`maxProfit = 0`

### i = 0

Current price = `7`

`minPrice = min(7, Integer.MAX_VALUE)`

`minPrice = 7`

Profit:

`7 - 7 = 0`

`maxProfit = 0`

---

### i = 1

Current price = `1`

`minPrice = min(1, 7)`

`minPrice = 1`

Profit:

`1 - 1 = 0`

`maxProfit = 0`

---

### i = 2

Current price = `5`

`minPrice = 1`

Profit:

`5 - 1 = 4`

`maxProfit = 4`

---

### i = 3

Current price = `3`

`minPrice = 1`

Profit:

`3 - 1 = 2`

`maxProfit = 4`

---

### i = 4

Current price = `6`

`minPrice = 1`

Profit:

`6 - 1 = 5`

`maxProfit = 5`

---

### i = 5

Current price = `4`

`minPrice = 1`

Profit:

`4 - 1 = 3`

`maxProfit = 5`

### Final Answer

`5`

Buy at `1` and sell at `6`.

---

## Algorithm

1. Initialize `minPrice` to `Integer.MAX_VALUE`.
2. Initialize `maxProfit` to `0`.
3. Traverse the array using `i`.
4. Update `minPrice` with the minimum price seen so far.
5. Calculate the profit using the current price and `minPrice`.
6. Update `maxProfit` with the maximum profit.
7. Return `maxProfit`.

---

## Java Solution

See `BestTimeToBuyAndSellStock.java`.

---

## Complexity

Time Complexity: `O(n)`

We traverse the array only once.

Space Complexity: `O(1)`

We use only a few variables regardless of the input size.

---

## Pattern

**Array + Greedy + One Pass**

---

## Key Takeaway

The main idea to remember:

**Find the minimum price so far → Calculate today's profit → Keep the maximum profit.**

Remember these two variables:

`minPrice` → cheapest price seen so far

`maxProfit` → best profit found so far

Mental template:

`Find minimum → Calculate profit → Keep maximum`