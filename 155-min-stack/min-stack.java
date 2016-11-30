# -*- coding:utf-8 -*-


# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
#
#
# push(x) -- Push element x onto stack.
#
#
# pop() -- Removes the element on top of the stack.
#
#
# top() -- Get the top element.
#
#
# getMin() -- Retrieve the minimum element in the stack.
#
#
#
#
# Example:
#
# MinStack minStack = new MinStack();
# minStack.push(-2);
# minStack.push(0);
# minStack.push(-3);
# minStack.getMin();   --> Returns -3.
# minStack.pop();
# minStack.top();      --> Returns 0.
# minStack.getMin();   --> Returns -2.


public class MinStack {
    public class Node{
        int val;
        int min;
        Node next;
        Node(int v,int m,Node n){
            val = v;
            min = m;
            next = n;
        }
    }
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        int min = x;
        if(head != null){
            min = head.min;
        }
        Node newNode = new Node(x,Math.min(x,min),head);
        head = newNode;
    }
    
    public void pop() {
        if(head != null){
            head = head.next;
        }
    }
    
    public int top() {
        if(head != null){
            return head.val;
        }else{
            return 0;
        }
        
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
