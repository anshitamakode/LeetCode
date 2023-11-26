class Pair{
    int s;
    int e;
    Pair(int s, int e){
        this.s = s;
        this.e = e;
    }
}
class MyCalendar {
    List<Pair> list = new ArrayList<>();
    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        for(Pair p : list){
            if(Math.max(p.s, start) < Math.min(p.e, end)) 
                return false;
        }
        list.add(new Pair(start, end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */