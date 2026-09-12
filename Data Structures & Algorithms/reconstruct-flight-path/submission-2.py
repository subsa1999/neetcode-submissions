class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        edges = defaultdict(list)

        for ticket in tickets:
            source, destination = ticket[0], ticket[1]
            edges[source].append(destination)
        
        for destination in edges.values():
            destination.sort(reverse=True)
        
        res = []

        def DFS(node):
            while edges[node]:
                next = edges[node].pop()
                DFS(next)
            
            res.append(node)

        DFS('JFK')
        res.reverse()

        return res