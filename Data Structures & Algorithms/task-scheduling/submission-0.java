class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];

        for (char c : tasks) {
            count[c - 'A']++;
        }

        MaxHeapWithCooldown heap = new MaxHeapWithCooldown(n);

        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) heap.add(new Task(((char)('A' + i)), count[i]));
        }

        int ans = 0;
        while (true) {
            Task t = heap.poll();
            if (t == null) return ans;
            // System.out.println(t.ch);
            ++ans;
        }
    }
}

class MaxHeapWithCooldown {
    private PriorityQueue<Task> pq = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.rem, t1.rem));

    private ArrayDeque<Task> queue = new ArrayDeque<>();
    private Map<Task, Integer> lastPolledTime = new HashMap<>();

    private final int cooldownTime;
    private int timer = -1;

    public MaxHeapWithCooldown(int t) {
        cooldownTime = t;
    }

    public void add(Task t) {
        pq.add(t);
    }

    public Task poll() {
        ++timer;
        if (!queue.isEmpty()) {
            if (timer - lastPolledTime.getOrDefault(queue.peek(), 0) > cooldownTime) {
                lastPolledTime.remove(queue.peek());
                pq.add(queue.poll());
            }
        }

        if (pq.isEmpty() && queue.isEmpty()) return null;
        if (pq.isEmpty() && !queue.isEmpty()) return new Task('.', 1);
        
        Task top = pq.poll();
        top.rem--;
        
        if (top.rem > 0) {
            queue.add(top);
            lastPolledTime.put(top, timer);
        }

        
        return top;
    }
}

class Task {
    char ch;
    int rem;

    public Task(char c, int r) {
        ch = c;
        rem = r;
    }
}
