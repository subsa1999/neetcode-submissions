class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums: return 0
        
        map = {}

        for any in nums:
            map[any] = -1
        
        # print(map)

        def find(n):
            if n not in map:
                return 0
            if map[n] != -1:
                return map[n]
            
            map[n] = 1 + find(n - 1)
            return map[n]
        
        mx = 1

        for any in nums:
            # print(find(any))
            mx = max(mx, find(any))

        return mx