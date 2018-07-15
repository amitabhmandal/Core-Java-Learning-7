package collection.learning.queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* A collection designed for holding elements prior to processing.
 * 
 * 
 * QUEUE IS AN INTERFACE
 * 
 * queues provide additional insertion, extraction, and inspection operations
 * 
 * 
 * Each of the methods are in two forms. Either it throws an exception if the 
 * operation fails or it returns null or false
 * 
 * Type of Operation    Throws exception        Returns special value
 *    Insert              add(e)                  offer(e)
 *    Remove              remove()                poll()
 *    Examine             element()               peek()
 * 
 * Queues typically, but not necessarily, order elements in a FIFO (first-in-first-out) manner. 
 * Among the exceptions are priority queues, which order elements according to their values.
 * 
 * Whatever ordering is used, the head of the queue is the element that would be removed by a call to remove or poll. 
 * 
 * It is possible for a Queue implementation to restrict the number of elements that it holds; such queues are known as bounded. 
 * Some Queue implementations in java.util.concurrent are bounded, but the implementations in java.util are not.
 * 
 * The add method, which Queue inherits from Collection, inserts an element unless it would violate the queue's capacity 
 * restrictions, in which case it throws IllegalStateException. The offer method, which is intended solely for use on bounded queues, 
 * differs from add only in that it indicates failure to insert an element by returning false.
 * 
 * The remove and poll methods both remove and return the head of the queue. Exactly which element gets removed is a 
 * function of the queue's ordering policy. The remove and poll methods differ in their behavior only when the queue is empty. 
 * Under these circumstances, remove throws NoSuchElementException, while poll returns null.
 * 
 * The element and peek methods return, but do not remove, the head of the queue. They differ from one another in precisely the same 
 * fashion as remove and poll: If the queue is empty, element throws NoSuchElementException, while peek returns null.
 * 
 * Queue implementations generally do not allow insertion of null elements. The LinkedList implementation, which was 
 * retrofitted to implement Queue, is an exception. For historical reasons, it permits null elements, but you should refrain 
 * from taking advantage of this, because null is used as a special return value by the poll and peek methods.
 * 
 * Queue implementations generally do not define element-based versions of the equals and hashCode methods but instead 
 * inherit the identity-based versions from Object.
 * 
 * The Queue interface does not define the blocking queue methods, which are common in concurrent programming. 
 * These methods, which wait for elements to appear or for space to become available, are defined in the 
 * interface java.util.concurrent.BlockingQueue, which extends Queue.
 * 
 * 
 * 
 * ===========================
 * FIRST IN FIRST OUT : QUEUES
 * ===========================
 * 
 * POSSIBLE TO HAVE A QUEUE OF BOUNDED SIZE AND YOU CANNOT PUT ANY MORE ELEMENT
 * 
 * ====================
 * HIGHEST PRIORITY OUT
 * ====================
 * 
 * ==========================
 * LAST IN FIRST OUT : STACKS
 * ==========================
 * 
 * 
 * IMPLEMENTATIONS
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */

public class QueueTester {

    public static void main(String[] args) {
        QueueExample.queueExample();
        ArrayToQueue.arrayToQueueExample();
        QueueToArray.queueToArrayExample();
        QueueOfferOperation.queueOfferOperationExample();
        QueueAddOperation.queueAddOperationExample();
        QueueRemoveOperation.queueRemoveOperationExample();
        QueuePollOperation.queuePollOperationExample();
        QueueElementOperation.queueElementOperationExample();
        QueueElementOperation.queueElementOperationExample();
        QueuePeekOperation.queuePeekOperationExample();
    }

}

class QueuePeekOperation {
    public static void queuePeekOperationExample() {
                 
         Queue<String> queue = new LinkedList<>();
         queue.add("one");
                 
         System.out.println(queue.peek());
         System.out.println(queue);
         queue.clear();
         System.out.println(queue.peek());
    }
 }

class QueueElementOperation {
    public static void queueElementOperationExample() {
                 
         Queue<String> queue = new LinkedList<>();
         queue.add("one");
                 
         System.out.println(queue.element());
         System.out.println(queue);
         queue.clear();
         System.out.println(queue.element());
    }
 }

class QueueExample {
    public static void queueExample() {

        Queue<String> queue = new LinkedList<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        System.out.println(queue);

        queue.remove("three");
        System.out.println(queue);
        System.out.println("Queue Size: " + queue.size());
        System.out.println("Queue Contains element 'two' or not? : " + queue.contains("two"));

        // To empty the queue
        queue.clear();
    }
}
class ArrayToQueue {
    public static void arrayToQueueExample() {
                
        String nums[] = {"one","two","three","four","five"};
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, nums);
        System.out.println(queue);
   }
}

class QueueToArray {
    public static void queueToArrayExample() {
                 
         Queue<String> queue = new LinkedList<>();
         queue.add("one");
         queue.add("two");
         queue.add("three");
         queue.add("four");
         queue.add("five");
                 
         String strArray[] = queue.toArray(new String[queue.size()]);
         System.out.println(Arrays.toString(strArray)); 

    }
 }


class QueueAddOperation {
    public static void queueAddOperationExample(){
                 
         BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

         System.out.println(queue.add("one"));
         System.out.println(queue.add("two"));
         System.out.println(queue);
         System.out.println(queue.add("three"));
         System.out.println(queue);
    }
 }

class QueueOfferOperation{
    public static void queueOfferOperationExample() {
        
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.offer("one"));
        System.out.println(queue.offer("two"));
        System.out.println(queue);
        System.out.println(queue.offer("three"));
        System.out.println(queue);
   }
}

class QueueRemoveOperation 
{
   public static void queueRemoveOperationExample() 
   {            
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");             
        System.out.println(queue);              
        System.out.println(queue.remove());
        System.out.println(queue.remove());             
        System.out.println(queue.remove());             
   }
}

class QueuePollOperation 
{
   public static void queuePollOperationExample()
   {            
        Queue<String> queue = new LinkedList<>();
        queue.offer("one");
        queue.offer("two");             
        System.out.println(queue);              
        System.out.println(queue.poll());
        System.out.println(queue.poll());               
        System.out.println(queue.poll());               
   }
}