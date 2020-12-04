import java.util.HashMap;
import java.util.Map;

class DoublyLinkedList{
    int key;
    int value;
    DoublyLinkedList right;
    DoublyLinkedList left;
}
public class LRUCache {
    Map<Integer,DoublyLinkedList> cache = new HashMap<>();
    DoublyLinkedList startNode, endNode;
    private final int LRU_CACHE_SIZE = 4;


    public void addEntry(int key,int value){

        if(cache.containsKey(key)){
            DoublyLinkedList entry = cache.get(key);
            entry.value = value;
            removeEntry(entry);
            addEntryToTheTop(entry);
        }
        else{
            DoublyLinkedList newNode = new DoublyLinkedList();
            newNode.key = key;
            newNode.value = value;
            newNode.left = null;
            newNode.right = null;
            System.out.println("cache.zize :"+cache.size());

            if(cache.size() > LRU_CACHE_SIZE){
                System.out.println("cache.zize :"+cache.size());
                cache.remove(endNode.key);
                removeEntry(endNode);
                addEntryToTheTop(newNode);
            }else{
                addEntryToTheTop(newNode);
            }
            cache.put(key,newNode);
        }
    }

    private void addEntryToTheTop(DoublyLinkedList entry) {
        entry.left = null;
        entry.right = startNode;
        if (startNode != null) {
            startNode.left = entry;
        }
        startNode = entry;
        if(endNode == null){
            endNode = startNode;
        }
    }

    private void removeEntry(DoublyLinkedList entry) {
        if(entry.left != null){
            entry.left.right = entry.right;
        }else{
            startNode = entry;
        }

        if(entry.right != null)
            entry.right.left = entry.left;
        else
            endNode = entry;
    }

    public int getEntry(int key){

        if(cache.containsKey(key)){
            DoublyLinkedList entry = cache.get(key);
            removeEntry(entry);
            addEntryToTheTop(entry);
            return entry.value;
        }

        return -1;

    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();

        lruCache.addEntry(1,1);
        lruCache.addEntry(8,10);
        lruCache.addEntry(3,5);
       // lruCache.addEntry(1,5);
        lruCache.addEntry(5,9);
        lruCache.addEntry(2,24);
        lruCache.addEntry(12,234);

        System.out.println(lruCache.getEntry(8));
        System.out.println(lruCache.getEntry(3));
        System.out.println(lruCache.getEntry(5));
        System.out.println(lruCache.getEntry(2));
        System.out.println(lruCache.getEntry(1));
    }
}
