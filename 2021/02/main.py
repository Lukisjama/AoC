with open('02.txt','r') as f:
    lines = f.readlines()

    v2 = 0
    v1 = 0
    horizontal = 0
    aim = 0
    for line in lines:
        num = int(line.split(' ')[1])
        if line.startswith('up'):
            aim -= num
            v1 -= num
        if line.startswith('down'):
            aim += num
            v1 += num
        if line.startswith('forward'):
            horizontal += num
            v2 += aim*num

print(horizontal * v1)
print(horizontal * v2)