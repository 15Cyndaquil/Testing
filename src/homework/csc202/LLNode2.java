public class LLNode2 {
		private Node last;
		
		public void enQueue(int data){
			if(isEmpty()){
				last = new Node(data);
				last.setNode(last);
			}else{
				Node tmp = last;
				last = new Node(data, last.getNode());
				tmp.setNode(last);
			}
		}
		
		
		public int deQueue(){
			if(!isEmpty()){
				int output = last.getNode().getData();
				if(last.getNode()==last){
					last=null;
				}else{
					last.setNode(last.getNode().getNode());
				}
				return output;
			}else
				return -1;
		}

		public int size(){
			if(!isEmpty()){
				Node tmp = last.getNode();
				int size=1;
				if(tmp!=last){
					size=1;
				}
				
				while(tmp!=last){
					size++;
					tmp=tmp.getNode();
				}
				return size;
			}else return 0;
		}
		
		public boolean isFull(){
			return false;
		}
		public boolean isEmpty(){
			return last==null;
		}
}
