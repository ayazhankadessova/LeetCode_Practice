class Solution:
    def minRefuelStops(self, target: int, startFuel: int, stations: List[List[int]]) -> int:
        count = 0
		# We sort the `stations` by the amount of fuel descendingly.
        stations.sort(key = lambda x : x[1], reverse = True)  # sort srarions by distance
		# To check if our carrying fuel is enough to finish the course
        while startFuel < target: #fuel can show distance trvelled
            for i in range(len(stations)):
				# To check if the `stations[i]` is within our range.
                if stations[i][0] <= startFuel:
                    startFuel += stations[i][1]
                    count += 1
                    stations.pop(i)
                    break
			# No when there are no more stations or no more stations within our range
            else:
                return -1
        return count