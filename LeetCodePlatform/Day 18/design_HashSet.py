class MyHashSet:

	def __init__(self):

		self.HashSet = set()

	def add(self, key: int) -> None:

		self.HashSet.add(key)

	def remove(self, key: int) -> None:

		self.HashSet.discard(key)

	def contains(self, key: int) -> bool:

		if key in self.HashSet:
			return True
		else:
			return False