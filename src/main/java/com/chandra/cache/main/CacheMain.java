package com.chandra.cache.main;

import com.chandra.cache.GenericCache;

public class CacheMain {

	 public static void main(String[] args) throws InterruptedException {
		 
		 CacheMain cacheMain = new CacheMain();
	 
	        System.out.println("\n\n Test Case 1: Add Remove Objects");
	        cacheMain.addRemoveObjects();
	        System.out.println("\n\n Test Case 2: Expired Cache Objects");
	        cacheMain.expiredCacheObjects();
	        System.out.println("\n\n Test Case 3: Objects Cleanup Time");
	        cacheMain.objectsCleanupTime();
	    }
	 
	    private void addRemoveObjects() {
	 
	       
	    	GenericCache<String, String> cache = new GenericCache<String, String>(200, 500, 6);
	 
	        cache.put("key1", "Object1");
	        cache.put("key2", "Object2");
	        cache.put("key3", "Object3");
	        cache.put("key4", "Object4");
	        cache.put("key5", "Object5");
	        cache.put("key6", "Object6");
	 
	        System.out.println("6 Cache Object Added.. cache.size(): " + cache.size());
	        cache.remove("key5");
	        System.out.println("One object removed.. cache.size(): " + cache.size());
	 
	        cache.put("key7", "Object7");
	        cache.put("key8", "Object8");
	        System.out.println("Two objects Added but reached maxItems.. cache.size(): " + cache.size());
	 
	    }
	 
	    private void expiredCacheObjects() throws InterruptedException {
	 
	       
	    	GenericCache<String, String> cache = new GenericCache<String, String>(1, 1, 10);
	 
	        cache.put("key1", "Object1");
	        cache.put("key2", "Object2");
	       
	        Thread.sleep(3000);
	 
	        System.out.println("Two objects are added but reached timeToLive. cache.size(): " + cache.size());
	 
	    }
	 
	    private void objectsCleanupTime() throws InterruptedException {
	        int size = 500000;
	 
	       
	 
	        GenericCache<String, String> cache = new GenericCache<String, String>(100, 100, 500000);
	 
	        for (int i = 0; i < size; i++) {
	            String value = Integer.toString(i);
	            cache.put(value, value);
	        }
	 
	        Thread.sleep(200);
	 
	        long start = System.currentTimeMillis();
	        cache.cleanup();
	        double finish = (double) (System.currentTimeMillis() - start) / 1000.0;
	 
	        System.out.println("Cleanup times for " + size + " objects are " + finish + " s");
	 
	    }
}
