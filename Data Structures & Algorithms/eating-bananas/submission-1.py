class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        lo, hi = 1, max(piles)
        ans = hi
        
        def canEat(mid: int, maxHour: int, piles: List[int]) -> bool:
            cnt = 0
            for n in piles:
                cnt += (n + mid - 1) // mid
            return cnt <= maxHour

        while lo <= hi:
            mid = lo + ((hi - lo) >> 1)
            
            # logic is if you can complete eating all bananas 
            # with 'mid' /hour rate then check if you can do it 
            # slightly lesser rate
            if canEat(mid, h, piles):
                ans = min(ans, mid)
                hi = mid - 1
            else:
                lo = mid + 1
        
        return ans