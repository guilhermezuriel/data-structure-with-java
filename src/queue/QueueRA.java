package queue;

public class QueueRA<Item> {
   private int N;
   private Item[] queue;

   public static void main(String[] args){
      QueueRA<Integer> queueRA = new QueueRA<Integer>();
      queueRA.enqueue(1);
      queueRA.enqueue(2);
      queueRA.enqueue(3);
      var tamanho = queueRA.size();
      for(int j = 0; j < tamanho; j++){
         System.out.println(queueRA.dequeue());
      }
   }

   public QueueRA() {
      this.queue = (Item[]) new Object[2];
      this.N = 0;
   }

   public void enqueue(Object item) {
      if (this.isFull(queue)) {
         this.resize(2 * N);
      }
      this.queue[N++] = (Item) item;
   }

   public Object dequeue() {
     Item item = this.queue[0];
      if(N > 0 && N == (this.queue.length) / 4){
         this.resize(queue.length / 2);
      }
      for(int j = 1; j < N; j++){
         this.queue[j - 1] = queue[j];
      }
      this.queue[--N] = null;
      return item;
   }

   private boolean isFull(Object[] queue) {
      return (this.N == this.queue.length);
   }

   private void resize(int newSize) {
      Item[] newQueue = (Item[]) new Object[newSize];
      for (int i = 0; i < N; i++) {
         newQueue[i] = this.queue[i];
      }
      this.queue = newQueue;
   }

   public int size() {
      return this.N;
   }

}
