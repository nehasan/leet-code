# Definition for singly-linked list.

class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end

# @param {ListNode} slow pointer, {ListNode} fast pointer
# @return {Boolean} based on cycle detection
def tortoise_hair(slow, fast)
  return true if slow == fast

  return false if fast.next.nil?

  return check_recursive(slow.next, fast.next.next)
end

# @param {ListNode} head
# @return {Boolean}
def hasCycle(head)
  return false if (head.nil? || head.next.nil? || head&.next&.next.nil?)

  slow = head
  fast = slow.next.next

  # Floyd's tortoise hair algorithm to detect a cycle in a list
  # Slow pointer jumps to next node in contrast fast pointer jumps to next to next node
  # By doing this slow and fast comes together if it has cycle in it.
  return tortoise_hair(slow, fast)
end

# list4 = ListNode.new(4)
# list3 = ListNode.new(3, list4)
list2 = ListNode.new(2)
list1 = ListNode.new(1, list2)
# list4.next = list2

puts hasCycle(list1)
