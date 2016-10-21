package test;

import java.util.List;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String [] args){
		Jedis jedis = new Jedis("localhost");
		
		System.out.println("Connection to Redis Server is succesfully");
		
		//set string to redis
		jedis.set("name", "Benni Luasti Sinurat");
		System.out.println("Nama " + jedis.get("name"));
		
		//store data to list redis
		jedis.lpush("data", "09 Februari 1994");
		jedis.lpush("data", "IT Developer");
		jedis.lpush("data", "PRAY");
		jedis.rpush("data", "Bedanya apa");
		
		//get data from list redis
		List<String> list = jedis.lrange("data", 0, 4);
		//Print data list
		for(int i=0; i<list.size() ; i++){
			System.out.println("Biodata diri \n" + list.get(i));
		}
		
		jedis.del("name");
		System.out.println("Name has been deleted");
		
		//test connection to Redis Server
		System.out.println("Server is running " + jedis.ping());
	}
}
