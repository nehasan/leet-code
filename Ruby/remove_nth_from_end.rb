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


# @param {ListNode} head
# @param {Integer} n
# @return {ListNode}
def remove_nth_from_end(head, n)
    return nil if head.nil?

    size = 0
    curr = head
    loop do
      break if curr.nil?
      size += 1
      curr = curr.next
    end

    nth = size - n

    # if nth <= 0
    #   head = head.next
    #   return head
    # end
    return head&.next if nth <= 0

    p "SIZE: #{size}, NTH: #{nth}"

    m = 0
    curr = head
    loop do
      m += 1
      if nth == m
        curr.next = curr&.next&.next
        break
      end
      curr = curr.next
    end

    return head
end

# head = ListNode.new(1, ListNode.new(2, ListNode.new(3, ListNode.new(4, ListNode.new(5)))))
head = ListNode.new(1, ListNode.new(2))

head = remove_nth_from_end(head, 2)

print(head)
