
public class arrayassign {
    private Integer a[];

    public arrayassign(int size)
    {
     a=new Integer[size];
    }
    public void setElement(int index,Integer element)
    {
        if(index>=0 && index<a.length)
            a[index]=element;
        else
            throw new RuntimeException("Array index is out of bounds");

    }
    public Integer getElement(int index)
    {
        if(index>=0 && index<a.length)
        return a[index];
        else throw new RuntimeException("Array index is out of bound");
    }
public class IntegerArrayIterator
    {
        private int index=-1;
IntegerArrayIterator(){};
        public boolean hasNext()
        {
        return index<a.length;
        }
        public Integer next()
        {
            if(index==a.length) throw new RuntimeException("Array index is out of bound");
            return a[++index];
        }
    }
    public IntegerArrayIterator getIterator(){
        return new IntegerArrayIterator();
    }
    public static void main(String[] args)
    {
        arrayassign obj=new arrayassign(10);
       for(int i=0;i<10;i++)
           obj.setElement(i,i*2);
       arrayassign.IntegerArrayIterator itr=obj.new IntegerArrayIterator();//this can be used when the IntegerArrayIterator is private
     
       while(itr.hasNext())
       {
           System.out.println(itr.next());
       }

    }
}
class ab1
{
    public static void main(String args[])
    {
        arrayassign obj1=new arrayassign(10);
        for(int i=0;i<10;i++)
            obj1.setElement(i,(i+1)*2);
        arrayassign.IntegerArrayIterator itr=obj1.new IntegerArrayIterator();//We have to make that inner class as public in order to make it accessible outside
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
    }
}

