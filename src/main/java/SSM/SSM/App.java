package SSM.SSM;

import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 UUID uuid = UUID.randomUUID();
    	 String s = uuid.toString() ;
    	 System.out.println(s);
    	 String uuidstr =s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
         System.out.println(uuidstr);
    }
}
