
puzzle = []
suma = 0

with open('06.txt', 'r') as file:
    rawPuzzle = file.read().replace('\n', ' ')

puzzle = rawPuzzle.split("  ")

for group in puzzle:
    if " " in group:
        print (group + ": " + str(len(set(group))-1))
        suma = suma + len(set(group)) - 1
    else:
        print(group + ": " + str(len(set(group))))
        suma = suma + len(set(group))

print(puzzle)
print(suma)


#for line in open('06.txt', 'r').readlines():
    #print(line)
    #if "//n//n" not in line:
        #print("______")


#print(len(set("aaaa")))