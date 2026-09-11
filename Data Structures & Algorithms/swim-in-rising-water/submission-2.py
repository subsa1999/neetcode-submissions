class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        dirs = [[-1, 0], [0, -1], [1, 0], [0, 1]]
        n = len(grid)
        visited = set()

        def canReach(t):
            if grid[0][0] > t:
                return False

            q = deque([(0, 0)])
            visited = {(0, 0)}

            while q:
                i, j = q.popleft()

                if i == n - 1 and j == n - 1:
                    return True

                for di, dj in dirs:
                    ni = i + di
                    nj = j + dj

                    if (
                        0 <= ni < n
                        and 0 <= nj < n
                        and (ni, nj) not in visited
                        and grid[ni][nj] <= t
                    ):
                        visited.add((ni, nj))
                        q.append((ni, nj))

            return False
        
        lo = min(min(row) for row in grid)
        hi = max(max(row) for row in grid)
        ans = hi

        while lo <= hi:
            mid = lo + (hi - lo) // 2
            visited = set()
            if canReach(mid):
                ans = mid
                hi = mid - 1
            else:
                lo = mid + 1

        return ans        



