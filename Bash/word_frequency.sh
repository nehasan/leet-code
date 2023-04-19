#! /bin/sh

# sed matches multiple spaces and turns into single one using s/ */ /g
# sed matches leading and trailing spaces and removes them using s/^[ \t]*//;s/[ \t]*$//
# the next tr of the pipeline trasnforms the words into new lines
# the first sort sort the each words lexically
# next uniq command with -c argument removes the duplicates and place frequency value before each word
# next sort with -nr /-rn sorts the resulting uniq list of words based on freq value
# awk is used to print
sed 's/  */ /g;s/^[ \t]*//;s/[ \t]*$//' < words.txt | tr ' ' '\n' | sort |  uniq -c | sort -nr | awk '{ print $2" "$1 }'