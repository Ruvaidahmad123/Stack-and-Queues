class MyStack {
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }
    StackNode top=null;
    // Function to push an integer into the stack.
    void push(int a) {
        StackNode newnode=new StackNode(a);
        if(top==null){
            top=newnode;
        }
        else{
            newnode.next=top;
            top=newnode;
        }
    }

    // Function to remove an item from top of the stack.
    int pop() {
        // Add your code here
        if(top==null)return -1;
        int data=top.data;
        top=top.next;
        return data;
    }
}
