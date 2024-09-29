class MyQueue
{
    QueueNode front=null;
    QueueNode rear=null;
    //Function to push an element into the queue.
	void push(int a)
	{
	    QueueNode newnode=new QueueNode(a);
        if(front==null && rear==null){
            front=newnode;
            rear=newnode;
        }
        else{
            rear.next=newnode;
            rear=newnode;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        if(front==null && rear==null){
            return -1;
        }
        int data=front.data;
        if(front==rear){
            front=null;
            rear=null;
            return data;
        }
        front=front.next;
        return data;
	}
}
