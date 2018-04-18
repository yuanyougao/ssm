package chapter17;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jdk.nashorn.internal.ir.debug.PrintVisitor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

public class SpringRedisTest {
	public static void main(String[] args) {
		ApplicationContext applicationcontext =
				new ClassPathXmlApplicationContext("redis-config.xml");
		RedisTemplate redisTemplate = (RedisTemplate)applicationcontext.getBean("redisTemplate");
		/*Role role = new Role();
		role.setId(1);
		role.setUsername("yuanyougao");*/
		//redisTemplate.opsForValue().set("role_1", role);
		/*Role role = (Role)redisTemplate.opsForValue().get("role_1");
		int size = redisTemplate.opsForValue().size("role_1").intValue();
		
		redisTemplate.opsForValue().set("key1", "yuanyougao");*/
		/*System.out.println("size:"+redisTemplate.opsForValue().size("key1").intValue());
		System.out.println("size:"+size);
		System.out.println(role.getUsername());*/
		
		//redisTemplate.delete("key1");
		//redisTemplate.opsForValue().append("key1", "andliuju");
		/*Map map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		redisTemplate.opsForValue().set("key3", map);*/
		/*Map getmap = (Map)redisTemplate.opsForValue().get("key3");
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Object key = entry.getKey();
			Object val = entry.getValue();
			System.out.println("key:"+key +"val:"+val);
		}*/
		Map map = new HashMap();
		map.put("1", "1");
		map.put("2", "2");
		
		 redisTemplate.opsForHash().putAll("hash", map);
		 redisTemplate.opsForHash().put("hash", "3", "3");
	}
}
