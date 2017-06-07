public class Driver {
	private static final int loop = 100;
		public static void main(String[] args){
			LLNode2 list = new LLNode2();
			
			for(int i=0; i<loop; i++){
				list.enQueue(i);
			}
			for(int i=0; i<loop; i++){
				System.out.println(list.deQueue()+" "+list.size());
			}
			
		}
}
