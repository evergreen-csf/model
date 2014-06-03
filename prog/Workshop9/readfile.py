import sys

filename = sys.argv[1]
# A file object from which data can be read.
try:
	inputfile = open(filename)

	linecount = int(inputfile.readline())

	print("Trying to read " + str(linecount) + " lines")

	lines = []

	for i in range(linecount):
		newline = inputfile.readline()
		newline.strip()
		lines.append(newline)

	lines.sort()

	for line in lines:
		print(line)

except IOError:
	print("Cannot find file " + filename)