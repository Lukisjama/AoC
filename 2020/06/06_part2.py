
puzzle = []
unique = {""}
count = 0
suma = 0
people = 0

with open('06.txt', 'r') as file:
    rawPuzzle = file.read().replace('\n', ' ')

puzzle = rawPuzzle.split("  ")
print (puzzle)

for group in puzzle:
    print (group)
    people = len(group.split(" "))
    print ("Počet lidí: " + str(people))
    for char in group:
        if (char != ' '):
            count = group.count(char);
            print ("Počet písmen: '" + char + "' je " + str(count))
            if count == people:
                print ("-Všichni odpověděli")
                if char not in unique:
                    print("--Ještě jsem nezapočítal")
                    unique.add(char)
                    suma += 1
                    print ("Suma je " + str(suma))
                else:
                    print ("--Už znám")
    unique.clear()
    print ("_______")
print(suma)
