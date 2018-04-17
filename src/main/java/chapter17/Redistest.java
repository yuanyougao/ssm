package chapter17;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
public class Redistest {

	public static void main(String[] args) {
		
		
		JedisPoolConfig  poolcfg = new JedisPoolConfig();
		poolcfg.setMaxIdle(50);//最大空闲
		poolcfg.setMaxTotal(100);//最大连接
		poolcfg.setMaxWaitMillis(20000);//最大等待毫秒数目
		JedisPool pool = new JedisPool(poolcfg ,"127.0.0.1",6379);//使用配置创建连接池
		Jedis jedis = pool.getResource();//从连接中获取
		//jedis.auth("123456");
		
		
		Jedis jedis1 = jedis;
		int i = 0;
		try {
			long start = System.currentTimeMillis();
			while (true) {
				long end = System.currentTimeMillis();
				if (end -start >= 1000) {
					break;
				}
				i++;
				System.out.println("写入test:"+i);
				jedis.set("test"+i, i+"");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jedis.close();
		}
	}
}
