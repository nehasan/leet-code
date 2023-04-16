class ListNode
    attr_accessor :val, :next
    def initialize(val = 0, _next = nil)
        @val = val
        @next = _next
    end
end

def print(list)
  curr = list
  loop do
    p curr.val
    break if curr.next.nil?
    curr = curr.next
  end
end

# @param {ListNode} list1
# @param {ListNode} list2
# @return {ListNode}
def merge_two_lists(list1, list2)
    # curr1 = list1
    # curr2 = list2
    head = nil
    tail = nil

    return nil if list1.nil? and list2.nil?

    loop do
      break if list1.nil? || list2.nil?

      if head.nil?

        if list1.val <= list2.val
          head = ListNode.new(list1.val)
          list1 = list1.next
        else
          head = ListNode.new(list2.val)
          list2 = list2.next
        end

        tail = head

      else
        if list1.val <= list2.val
          new_node = ListNode.new(list1.val)
          tail.next = new_node
          list1 = list1.next
        else
          new_node = ListNode.new(list2.val)
          tail.next = new_node
          list2 = list2.next
        end
        tail = tail.next
      end
    end

    if !list1.nil? || !list2.nil?
      curr = list1.nil? ? list2 : list1

      loop do
        if tail.nil?
          head = ListNode.new(curr.val)
          tail = head
        else
          tail.next = ListNode.new(curr.val)
          tail = tail.next
        end
        break if curr.next.nil?
        curr = curr.next
      end
    end

    # print(head)
    head
end

# list1 = ListNode.new(1, ListNode.new(2, ListNode.new(3, ListNode.new(4))))
# list2 = ListNode.new(1, ListNode.new(4, ListNode.new(5, ListNode.new(7))))
# list1 = nil
# list2 = ListNode.new(1, ListNode.new(4, ListNode.new(5, ListNode.new(7))))
#
# merge_two_lists(list1, list2)
#
# list1 = ListNode.new(1, ListNode.new(2, ListNode.new(3, ListNode.new(4))))
# list2 = nil
#
# merge_two_lists(list1, list2)

list1 = ListNode.new(1, ListNode.new(2, ListNode.new(4)))
list2 = ListNode.new(1, ListNode.new(3, ListNode.new(6)))
list3 = ListNode.new(1, ListNode.new(5, ListNode.new(7)))

merge_two_lists(list1, list2)

lists = [list1, list2, list3]
result = nil
lists.each do |list|
  result = merge_two_lists(result, list)
end

print(result)
