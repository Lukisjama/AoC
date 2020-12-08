
accumulator = 0;
processedLines = set()
puzzle = {}
i, row = 0, 0

def isAlreadyProcessed (line):
    if line not in processedLines:
        processedLines.add(line)
        print(processedLines)
        return False
    return True

def calcAccumulator (n):
    global accumulator, row
    accumulator += n
    row += 1
    #print ("Acc: " + str(accumulator))
    return accumulator

def jumpTo (l):
    global row
    row += l
    print ("Řádek: " + str(row))


def doNop (l):
    global row
    row += 1


for lines in open('08.txt', 'r').readlines():
    puzzle[i] = lines
    i += 1


while (isAlreadyProcessed(row) == False):
    print ("Řádek: " + str(row))
    print(puzzle[row])
    if (puzzle[row].split(" ")[0] == "acc" ):
        calcAccumulator(int(puzzle[row].split(" ")[1]))
    elif (puzzle[row].split(" ")[0] == "jmp" ):
        jumpTo(int(puzzle[row].split(" ")[1]))
    elif (puzzle[row].split(" ")[0] == "nop" ):
        doNop(int(puzzle[row].split(" ")[1]))
        print("NUDA")
    else:
        break
    print ("Accumulator je: " + str(accumulator))
    print("______________________-")





#print ("Ještě jedu, řádek: " + str(row))




