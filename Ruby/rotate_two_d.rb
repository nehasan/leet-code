class Rotate2D
    # @param {Integer[][]} matrix
    # @param {Integer} i
    # @param {Integer} j
    # @param {Integer} ini_row_indx, initial row index
    # @param {Integer} ini_col_indx, initial column index
    # @param {Integer} last_row_indx, last row index
    # @param {Integer} last_col_indx, initial column index
    # @param {Integer} value, value of previous index to be put into current index
    # @param {Integer} dir, direction for recursive traverse
    # @return {Void} void
    def rotate_2D(matrix, i, j, ini_row_indx, ini_col_indx,
        last_row_indx, last_col_indx, value, dir)

        if i >= ini_row_indx and i <= last_row_indx and j >= ini_col_indx and j <= last_col_indx
            if dir == 'right'
                j_temp = j + 1

                if j_temp > last_col_indx
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i + 1, j, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'down')
                else
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i, j + 1, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'right')
                end
            elsif dir == 'down'
                i_temp = i + 1

                if i_temp > last_row_indx
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i, j - 1, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'left')
                else
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i + 1, j, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'down')
                end
            elsif dir == 'left'
                j_temp = j - 1

                if j_temp < ini_col_indx
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i - 1, j, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'up')
                else
                    forward_value = matrix[i][j]
                    matrix[i][j] = value

                    rotate_2D(matrix, i, j - 1, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'left')
                end
            else
                i_temp = i - 1

                if i_temp < ini_row_indx
                    # forward_value = matrix[i][j]
                    matrix[i][j] = value

                    # rotate_2D(matrix, i, j + 1, ini_row_indx, ini_col_indx,
                                # last_row_indx, last_col_indx, forward_value, 'right')
                else
                    forward_value = matrix[i][j]
                    matrix[i][j] = value
                    
                    rotate_2D(matrix, i - 1, j, ini_row_indx, ini_col_indx,
                                last_row_indx, last_col_indx, forward_value, 'up')
                end
            end
        end
    end

    # @param {Integer[][]} matrix
    # @return {Void} Do not return anything, modify matrix in-place instead.
    def rotate(matrix)
        # matrix.each do |row|
        #     p row
        # end

        row_size = matrix.length
        col_size = matrix[0].length

        n = col_size / 2
        k = 0
        i = 0
        j = 1

        ini_row_indx = 0
        ini_col_indx = 0
        last_row_indx = row_size - 1
        last_col_indx = col_size - 1

        until k > n
            m = last_col_indx - ini_col_indx
            l = 0
            until l >= m
                rotate_2D(matrix, i, j, ini_row_indx, ini_col_indx,
                        last_row_indx, last_col_indx, matrix[i][j-1], 'right')
                l += 1
            end

            i += 1
            j += 1
            k += 1
            ini_row_indx += 1
            ini_col_indx += 1
            last_row_indx -= 1
            last_col_indx -= 1
        end

        matrix.each do |row|
            p row
        end
    end
end

# matrix = [[1, 2], [3, 4]]
matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
# matrix = [[1, 2, 3, 4], [5, 6, 7, 8], [9 , 10, 11, 12], [13, 14, 15, 16]]

obj = Rotate2D.new
obj.rotate matrix