class SetZeros
    def modified_dfs(matrix, r, c, i, j, dir)
        if ((i >= 0 && i < r) && (j >= 0 && j < c))
            matrix[i][j] = 0

            if (dir == 0) # consider left
                modified_dfs(matrix, r, c, i, (j - 1), 0)
            elsif dir == 1 # consider up
                modified_dfs(matrix, r, c, (i - 1), j, 1)
            elsif dir == 2 # consider right
                modified_dfs(matrix, r, c, i, (j + 1), 2)
            elsif dir == 3 # consider down
                modified_dfs(matrix, r, c, (i + 1), j, 3)
            else
                modified_dfs(matrix, r, c, i, (j - 1), 0)
                modified_dfs(matrix, r, c, (i - 1), j, 1)
                modified_dfs(matrix, r, c, i, (j + 1), 2)
                modified_dfs(matrix, r, c, (i + 1), j, 3)
            end
        end
    end
    
    def set_zeros(matrix)
        rows = matrix.length
        cols = matrix[0].length
        coordinates = []

        i = 0
        while i < rows
            j = 0
            while j < cols
                coordinates << [i, j] if matrix[i][j] == 0
                j += 1
            end
            i += 1
        end

        coordinates.each do |coord|
            modified_dfs(matrix, rows, cols, coord[0], coord[1], nil)
        end
    end
end

# matrix = [[1, 1, 1], [1, 0, 1], [1, 1, 1]]
matrix = [[0, 1, 2, 0], [3, 4, 5, 2], [1, 3, 1, 5]]

obj = SetZeros.new
obj.set_zeros(matrix)

puts matrix.to_s