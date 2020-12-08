map = []

def count_trees_on_slope(map, slope_x, slope_y): #Y je sloupec, X je radek
    wrap = len(map[0]) #delka radku
    posx = 0
    posy = 0

    treecount = 0

    #print (len(map))
    while posy < len(map): #dokud je Y mensi nez cely svah, neboli dokud nejsem na konci
        if posx >= wrap: #Jestli jsem na konci radku?
            posx -=wrap
        if map[posy][posx] == "#": #Je tam strom?
            treecount +=1w
        posy += slope_y
        posx += slope_x

    print("Right: " + str(slope_x) + ", Down: " + str(slope_y) + " = " + str(treecount))
    return treecount

for line in open('03.txt', 'r').readlines():
    map.append(line.rstrip())

res = 1
res *= count_trees_on_slope(map, 1, 1)
res *= count_trees_on_slope(map, 3, 1)
res *= count_trees_on_slope(map, 5, 1)
res *= count_trees_on_slope(map, 7, 1)
res *= count_trees_on_slope(map, 1, 2)
print(res)
