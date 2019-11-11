import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.account.NewAccountDao;

public class Test implements Runnable{
	
	private static int local_i;
	private Object lock=new Object();
	public void run()  
    {  
		
    	local_i = 4;  
        System.out.println("[" + Thread.currentThread().getName()  
                + "]get local_i value:" + local_i);  
        local_i = 10;  
        System.out.println("[" + Thread.currentThread().getName()  
                + "]get local_i*2 value:" + local_i * 2);  
	
        
    }  
      
    public static void main(String[] args)  
    {  Session str=new Configuration().configure().buildSessionFactory().getCurrentSession();
    str.persist(object);
//        Test t = new Test();  
//        //启动尽量多的线程才能很容易的模拟问题  
//        for (int i = 0; i < 3000; i++)  
//        {  
//            //每个线程对在对象t中运行，模拟单例情况   
//            new Thread(t, "Thread" + i).start();  
//        } 
    	CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
    		String string="ahhaha";
    		return string;
    	});
    	
    	
    	
    	CompletableFuture<String> completableFuture1=CompletableFuture.supplyAsync(()->{

				return "hahah";
			
		}).whenComplete((str,ex)->{
			System.out.println(str);
		});
    	
    	
    	
    	for (int i = 0; i < 3000; i++)  
          {  
    	CompletableFuture.runAsync(new Test());
    	System.out.println("---------T:"+i);
          }
    }  
    
}
