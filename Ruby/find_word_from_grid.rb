class FindWordFromGrid
    def mDFS(grid, r, c, word, p, i, j, dir)
        if (p < word.length) && ((i >= 0 && i < r) && (j >= 0 && j < c))
            if grid[i][j] == word[p]
                if dir == 'up'
                    return mDFS(grid, r, c, word, p + 1, i - 1, j, 'up')
                elsif dir == 'down'
                    return mDFS(grid, r, c, word, p + 1, i + 1, j, 'down')
                elsif dir == 'left'
                    return mDFS(grid, r, c, word, p + 1, i, j - 1, 'left')
                elsif dir == 'right'
                    return mDFS(grid, r, c, word, p + 1, i, j - 1, 'right')
                else
                    return mDFS(grid, r, c, word, p + 1, i - 1, j, 'up') ||
                        mDFS(grid, r, c, word, p + 1, i + 1, j, 'down') ||
                        mDFS(grid, r, c, word, p + 1, i, j - 1, 'left') ||
                        mDFS(grid, r, c, word, p + 1, i, j + 1, 'right')
                end
            else
                return false
            end
        end
        # puts "HERE | P: #{p} | I: #{i} | J: #{j} | DIR: #{dir}"

        return p == word.length ? true : false
    end

    def find_word(grid, words)
        # write your code here
        rows = grid[0].length
        cols = grid.length

        words.each do |word|
            i = 0
            found = false
            while i < rows
                j = 0
                while j < cols
                    if (grid[i][j] == word[0] && mDFS(grid, rows, cols, word, 0, i, j, nil))
                        found = true
                        break
                    end
                    j += 1
                end
                break if found
                i += 1
            end
            found ? printf("%s ", "Yes") : printf("%s ", "No")

        end

    end

end


grid = [['T', 'A', 'C'], ['I', 'D', 'O'], ['N', 'O', 'M']]
words = ['MOM', 'CAT', 'MOC']

obj = FindWordFromGrid.new
obj.find_word(grid, words)