/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    int current = 0;
    List<Integer> list = new ArrayList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for(NestedInteger val : nestedList){
            helper(val);
        }
    }
    public void helper(NestedInteger val){
        if(val.isInteger()){
            list.add(val.getInteger());
            return;
        }
        for(NestedInteger x : val.getList()){
            helper(x);
        }
    }

    @Override
    public Integer next() {
        return list.get(current++);
    }

    @Override
    public boolean hasNext() {
        return current < list.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */