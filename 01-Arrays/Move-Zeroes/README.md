# Move Zeroes

## Problem

Given an integer array `nums`, move all `0`s to the end of the array while maintaining the relative order of the non-zero elements.

The operation must be performed in-place.

---

## Examples

### Example 1

Input: `nums = [0, 1, 0, 3, 12]`

Output: `[1, 3, 12, 0, 0]`

Explanation:

The non-zero elements are `1`, `3`, and `12`.

Move them to the beginning while maintaining their original order, then fill the remaining positions with `0`.

---

### Example 2

Input: `nums = [0]`

Output: `[0]`

Explanation:

The array contains only one element, which is already `0`.

---

### Example 3

Input: `nums = [1, 2, 3]`

Output: `[1, 2, 3]`

Explanation:

There are no zeroes, so the array remains unchanged.

---

## Approach

We use a **Two Pointer / Write Index** approach.

We use two variables:

- `i` → scans every element in the array.
- `k` → keeps track of the position where the next non-zero element should be placed.

### Core Idea

First, move all non-zero elements to the beginning of the array.

Whenever `nums[i]` is not zero:

`nums[k] = nums[i]`

Then increment `k`:

`k++`

After all non-zero elements have been moved to the front, fill the remaining positions with `0`.

---

## Step-by-Step Dry Run

Input:

`nums = [0, 1, 0, 3, 12]`

Initially:

`k = 0`

### i = 0

`nums[i] = 0`

It is zero, so skip it.

Array:

`[0, 1, 0, 3, 12]`

`k = 0`

---

### i = 1

`nums[i] = 1`

It is non-zero.

Place it at position `k`:

`nums[0] = 1`

Array:

`[1, 1, 0, 3, 12]`

Then:

`k = 1`

---

### i = 2

`nums[i] = 0`

It is zero, so skip it.

`k = 1`

---

### i = 3

`nums[i] = 3`

It is non-zero.

Place it at position `k`:

`nums[1] = 3`

Array:

`[1, 3, 0, 3, 12]`

Then:

`k = 2`

---

### i = 4

`nums[i] = 12`

It is non-zero.

Place it at position `k`:

`nums[2] = 12`

Array:

`[1, 3, 12, 3, 12]`

Then:

`k = 3`

---

## Fill Remaining Positions With Zeroes

After the first loop:

`k = 3`

The non-zero elements are now at the beginning:

`[1, 3, 12, _, _]`

The second loop fills the remaining positions with `0`.

Final result:

`[1, 3, 12, 0, 0]`

---

## Algorithm

1. Initialize `k = 0`.
2. Traverse the array using `i`.
3. If `nums[i]` is not zero:
    - Store `nums[i]` at `nums[k]`.
    - Increment `k`.
4. After processing all elements, fill the remaining positions with `0`.
5. The non-zero elements remain in their original order.

---

## Java Solution

See `MoveZeroes.java`.

---

## Complexity

Time Complexity: `O(n)`

We traverse the array at most twice, so the overall complexity is `O(n)`.

Space Complexity: `O(1)`

We modify the array in-place and use only a few variables.

---

## Pattern

**Array + Two Pointer / Write Index**

---

## Key Takeaway

Remember the roles of the two variables:

`i` → scans the entire array.

`k` → points to where the next non-zero element should be placed.

Mental Template:

`Scan → Find non-zero → Place at k → Increment k → Fill remaining with zero`

Example:

`[0, 1, 0, 3, 12]`

becomes:

`[1, 3, 12, 0, 0]`

The relative order of the non-zero elements is preserved.