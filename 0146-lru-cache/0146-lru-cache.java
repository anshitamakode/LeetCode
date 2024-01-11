class LRUCache
{
    int capacity;
    Queue<Integer> q = new LinkedList<>();
    Map<Integer,Integer> map = new HashMap<>();
    
    public LRUCache(int capacity) 
    {
        this.capacity = capacity;
    }
    
    public int get(int key)
    {
        if(map.containsKey(key)) 
        {
            q.remove(key);
            q.add(key);
            return map.get(key);
        } 
        else 
            return -1; 
    }
    public void put(int key, int value) 
    {
        if(map.containsKey(key))
        {
            q.remove(key);
            q.add(key);
            map.put(key,value);
        }
        else 
        {
            if(q.size() < capacity)
                q.offer(key);
            else 
            {
                map.remove(q.remove());
                q.add(key);
            }
            map.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
