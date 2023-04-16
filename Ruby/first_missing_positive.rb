# Write a method to output the smallest positive integer that is missing
# from an array that can contain positive and negative integers.

# You can modify the original array.

# Be prepared to speak about the time and space complexity of your solution.

# def first_missing_positive(nums)
#   nums = nums.select { |x| x > 0 }
#   return 1 if nums.length == 0
#
#   nums.sort!
#
#   nums.each_with_index do |x, i|
#     next if x <= 0
#
#     return 1 if (i == 0 and x > 1)
#
#     return x + 1 if (i == nums.length - 1)
#
#     next_num = nums[i + 1]
#     # p next_num
#     if (next_num - x) > 1
#       return x + 1
#     end
#   end
# end

require 'set'

def first_missing_positive(numbers)
  return 1 if numbers.length == 0

  set = Set.new(numbers)

  p set
  start = 1
  while set.include?(start)
    start += 1
  end

  return start
end

numbers = [-1, 0, 2, 3, 4, 5]
numbers = [-1]
numbers = [1, 2, 3, 4, 5]
numbers = [2147483647]
p first_missing_positive numbers