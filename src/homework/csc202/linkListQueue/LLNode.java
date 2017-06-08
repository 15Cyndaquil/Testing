package homework.csc202.linkListQueue;

public class LLNode {
		private Node first, last;
		
		public void enQueue(int data){
			if(isEmpty()){
				first = new Node(data);
				last = first;
			}else if(first.getNode()==null){
				first.setNode(new Node(data));
				last = first.getNode();
			}else{
				last.setNode(new Node(data));
				last = last.getNode();
			}
		}
		
		
		public int deQueue(){
			if(!isEmpty()){
				int output = first.getData();
				if(last==first){
					first=null;
					last=null;
				}else{
					first = first.getNode();
				}
				return output;
			}else
				return -1;
		}

		public int size(){
			Node tmp = first;
			int size=0;
			while(tmp!=null){
				size++;
				tmp=tmp.getNode();
			}
			return size;
		}
		
		public boolean isFull(){
			return false;
		}
		public boolean isEmpty(){return last==null;}
}
