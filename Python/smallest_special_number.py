import sys

'''
testCases = input()

for line in sys.stdin:
    if 'q' == line.rstrip():
        break
    print(f'Input : {line}')
 
print("Exit")
'''

def transform(a = 2) -> int:
    if a == 1:
        print(a + 2);
        return a + 2
    return a

total = 1

for x in [3,5,1]:
    total = total + transform(x)
    print(total)

print(total)