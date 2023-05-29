# Leet code 451: Sort Characters By Frequency

class FrequencySort:
    
    # Algorithm: sorting hashmap
    # store each character to a hashmap along with the number of times it appeared
    # example: tree, hashmap -> { t: 1, r: 1, e: 2 }
    # next sort the hashmap based on value -> { e: 2, r: 1, t: 1 }
    # iterate over the hashmap and build a new string based on the frequency of the characters
    # return the resulting string

    # @param {String} s, incoming string to process
    # @return {String} final processed string
    def frequencySort(self, s: str) -> str:
        final_str = ''
        hashmap = {}
        
        # read each char and push them into a map along with their frequency
        for c in s:
            try:
                hashmap[c] = hashmap[c] + 1
            except:
                hashmap[c] = 1
        
        # sort the map based on the value of each pair
        sorted_map = { k: v for k, v in sorted(hashmap.items(), key=lambda item: item[1], reverse=True) }
        # print(sorted_map)
        
        # build a new string using the value and append each char number of times
        #  it appeared in descending order
        for k, v in sorted_map.items():
            for n in range(0, v):
                final_str += k
        
        return final_str


s = 'tree'
obj = FrequencySort()
print(obj.frequencySort(s))