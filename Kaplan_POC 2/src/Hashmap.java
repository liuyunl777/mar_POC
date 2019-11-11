import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.expression.MapAccessor;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.thymeleaf.expression.Arrays;

import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer;
import com.sun.xml.fastinfoset.util.StringArray;

import net.sf.ehcache.search.aggregator.Count;
import net.sf.ehcache.util.SetAsList;

public class Hashmap implements Cloneable {
	Hashtable<Integer, String> h = 
            new Hashtable<Integer, String>(); 
	public static  Map count(String str) {
		
		Map<String,String> tbale=new HashTable<String,String>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		String[] s=str.split(" ");
		for(int i=0;i<s.length;i++){
			int a=Integer.parseInt(s[i]);
			map.put(a,map.getOrDefault(a, 0)+1);

		}
		return map;
	}
	
	public static void main(String[] args) {
		String str="21 1 31 9 8 8 7 17 6 2 73 8 78 74 98 12 73 82 3";
		Map<Integer,Integer> m=count(str);
		Set<Entry<Integer, Integer>> s=m.entrySet();
		final int max=0;
		Integer ans=s.stream().map(x->x.getValue())
		.reduce(0, (a,b)->{
			
			return Math.max(a, b);
		});
		System.out.print(ans);		
		
	}
}
