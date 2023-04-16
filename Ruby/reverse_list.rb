# Definition for singly-linked list.

class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end

# @param {ListNode} head
# @return {ListNode}
def reverse_list(head)
    return nil if head.nil?

    stack = []
    curr = head
    loop do
      stack << curr.val
      break if curr.next.nil?
      curr = curr.next
    end

    curr = head
    loop do
      curr.val = stack.pop
      break if curr.next.nil?
      curr = curr.next
    end

    head
end
