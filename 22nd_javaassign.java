 class Singleton {
    String s="Hello";
   static singleton obj=null;
    private singleton(){

    };
    public  void fun()
    {
        System.out.println(s);
    }
    public static singleton single()
    {
        if(obj==null)
            obj=new singleton();

        return obj;
    }
}
public class Singleton12
{
    public static void main(String[] args) {

      singleton s= singleton.single();
      singleton s1=singleton.single();
        System.out.println(s.hashCode()+"  "+s1.hashCode());
      s.fun();

    }
}
