import copy

class Scheduling:
    def schedule(self, A: [[int]]) -> int:
        cross = []
        normal = []
        output = []
        for i in A:
            if i[0] > i[1]:
                cross.append(i)
            else:
                normal.append(i)
        b = copy.deepcopy(normal)
        b.sort(key=lambda x: x[1])
        r = b[0][1]
        count = 1
        for i in range(1, len(b)):
            start = b[i][0]
            end = b[i][1]
            if start >= r:
                count += 1
                r = end
        output.append(count)

        for i in cross:
            count = 1
            end = i[1]
            start = i[0]
            for j in b:
                if (j[0] >= end) and (j[1] <= start):
                    count += 1
                    end = j[1]
            output.append(count)
        return max(output)
