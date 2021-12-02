num = []
inc = 0
windows_size = 3


for line in open('01.txt', 'r').readlines():
    nEntry = int(line)
    num.append(nEntry)

for i in range(len(num)-1):
    if num[i+1]>num[i]:
        inc+=1
        print("Increment: " + str(inc))



