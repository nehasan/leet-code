class SortCharFreq

  # Algorithm: sorting hashmap
  # store each character to a hashmap along with the number of times it appeared
  # example: tree, hashmap -> { t: 1, r: 1, e: 2 }
  # next sort the hashmap based on value -> { e: 2, r: 1, t: 1 }
  # iterate over the hashmap and build a new string based on the frequency of the characters
  # return the resulting string

  # @param {String} s, incoming string to process
  # @return {String} final processed string
  def frequency_sort(s)
    final_string = ''
    hash_map = {}
    # read each char and push them into a map along with their frequency
    s.split('').each do |c|
      hash_map[c] = (hash_map[c].nil? ? 0 : hash_map[c]) + 1
    end

    # sort the map based on the value of each pair
    sorted = hash_map.sort_by { |k, v| v }.reverse
    # sorted = hash_map.sort_by { |k, v| -v }
    # sorted = hash_map.sort { |x, y| y <=> x }
    # puts(sorted)

    # build a new string using the value and append each char number of times
    #  it appeared in descending order
    sorted.each do |key, val|
      val.times do
        final_string += key
      end
    end

    return final_string
  end

end


s = 'tree'
s = "cccaaa"
s = 'Aabb'
instance = SortCharFreq.new
puts(instance.frequency_sort(s))
