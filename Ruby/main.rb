# a = { a: 2, b: 1, c: 5, d: 4, e: 3 }
# a = a.sort { |x, y|  x[1] <=> y[1] }
# puts a.to_s

# arr = [2,3,4,5]
#
# arr = arr.each.inject(0) {|sum, x| sum + x}
# puts arr

class List
  attr_accessor :val, :next

  def initialize(_val = 0, _next = nil)
    @val = _val
    @next = _next
  end

  # def initialize(_val, _next)
  #   @val = _val
  #   @next = _next
  # end
end

arr = [1, 2, 3]

head = List.new(arr.first)
tail = nil
arr = arr[1..(arr.length - 1)]
# puts arr
# _next = List.new
# head.next = _next
_next = head

arr.each do |x|
  _next_next = List.new(x)
  _next.next = _next_next
  _next = _next.next
  tail = _next
end
# head = _next
puts head.val
puts head.next

puts tail.val
puts tail.next

curr = head
stack = []
loop do
  stack << curr.val
  break if curr.next.nil?

  curr = curr.next
end

puts stack.to_s

curr = head
loop do
  curr.val = stack.pop
  break if stack.empty?

  curr = curr.next
end

curr = head
loop do
  puts curr.val
  break if curr.next.nil?

  curr = curr.next
end
