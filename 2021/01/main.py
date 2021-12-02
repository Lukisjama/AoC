num = []
inc = 0
windows_size = 3


for line in open('01.txt', 'r').readlines():
    nEntry = int(line)
    num.append(nEntry)

for i in range(len(num)-1):
    if num[i+1]>num[i]:
        inc+=1
        #print("Increment: " + str(inc))

print ("First part: " + str(inc))
inc = 0

for i in range(windows_size + 1, len(num) + 1):
    if sum(num[i-windows_size:i]) > sum(num[i - windows_size-1:i-1]):
        #print(str(num[i - windows_size:i]) + " > " + str(num[i - windows_size - 1:i - 1]))
        inc += 1
print ("Second part: " + str(inc))