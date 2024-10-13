'''
1.Nested Loop
    arr = [1,2,3,4,5] , target = 6
    i = 0, j = 4
    sum = 6 -> return 6
    Time: O(n**2)
    Space: O(1)
2.Two Pointer
    arr = [1,2,3,4,5] , target = 6
    sort()
    i = 0, j = 4
    if sum == target -> return sum
    elif sum < target -> i++
    else -> j--
    Time: O(nlogn)
    Space: O(1)
3.HashMap
    arr = [1,2,3,4,5] , target = 6
    dic = {}
    i = 0
    if dic[target - arr[i]] -> return
    elif dic[arr[i]] = i
    Time: O(n)
    Space: O(n)
'''


def find_two_sum_two_pointer(nums, target):
    nums.sort()
    left, right = 0, len(nums) - 1
    while left < right:
        current_sum = nums[left] + nums[right]
        if current_sum == target:
            return (nums[left], nums[right])
        elif current_sum < target:
            left += 1
        else:
            right -= 1
    return None


def find_two_sum(nums, target):
    num_map = {}
    for num in nums:
        complement = target - num
        if complement in num_map:  # Check if the complement exists in the map
            return [complement, num]
        num_map[num] = True  # Store the current number in the map
    return None


print(find_two_sum([1, 2, 3, 4, 5], 6))
