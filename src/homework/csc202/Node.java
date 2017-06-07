public class Node {
	private int data;
	private Node node;
	
	public Node(int data){
		this.data = data;
		node = null;
	}
	
	public Node(int data, Node node){
		this.data = data;
		this.node = node;
	}

	
	public int getData() {
		return data;
	}
	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}
	public void setData(int data) {
		this.data = data;
	}
	
}
