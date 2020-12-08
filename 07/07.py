puzzle = []
currentBriefcase = []
myBriefs = {"shiny gold", "shiny white","striped indigo"}
validBriefs = set()

w, h = 6, 594;
data = [[0 for x in range(w)] for y in range(h)]

i,j = 0, 0;

for line in open('07.txt', 'r').readlines():
    puzzle = puzzle + line

print(puzzle)

for brief in myBriefs:
    for row in puzzle:
        if brief in row:
            validBriefs.add(row)
            print ("Přidána " + str(len(validBriefs)) + ". položka: "+ row)

print (len(validBriefs))



