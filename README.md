# caching
caching library

Here I am creating and using a simple thread-safe Java in-memory cache.

characteristic of the program :
------------------------------
* Items will expire based on a time to live period.
* Cache will keep most recently used items if you will try to add more items then max specified.
* For the expiration of items we can timestamp the last access and in a separate thread remove the 
  items when the time to live limit is reached. This is nice for reducing memory pressure for applications that have 
  long idle time in between accessing the cached objects.
* We can also see all the operations usage in class: CacheMain.java

Operations :
------------
put(K,V): put the object in cache 
get(K): Get the object based on key
remove(k) : Remove the object from cache 
cleanup() : to clean up entire cache.
