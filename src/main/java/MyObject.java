/**
 * @author xuan
 * @date 2019-04-25 10:24.
 */

public class MyObject {

    private volatile static MyObject myObject;

    private MyObject(){

    }
    public static MyObject getInstance(){
        if(myObject==null){
            synchronized (MyObject.class){
                if (myObject==null){
                    myObject=new MyObject();
                }
            }
        }

        return myObject;
    }

}
