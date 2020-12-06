
rawPuzzle = ""
puzzle = []

for line in open('04.txt', 'r').readlines():
    puzzle = puzzle + line

#puzzle = puzzle.replace("/n"," ")

print(puzzle)
