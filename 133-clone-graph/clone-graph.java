# -*- coding:utf-8 -*-


# Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
#
#
#
#
# OJ's undirected graph serialization:
#
#
# Nodes are labeled uniquely.
#
#
# We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
#
#
#
#
# As an example, consider the serialized graph {0,1,2#1,2#2,2}.
#
#
#
# The graph has a total of three nodes, and therefore contains three parts as separated by #.
#
# First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
# Second node is labeled as 1. Connect node 1 to node 2.
# Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
#
#
#
#
# Visually, the graph looks like the following:
#
#        1
#       / \
#      /   \
#     0 --- 2
#          / \
#          \_/


/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // if(node == null) return null;
        // HashMap<Integer,UndirectedGraphNode> map = new HashMap<>();
        // int start = node.label;
        // UndirectedGraphNode startNode = new UndirectedGraphNode(start);
        // map.put(start,startNode);
        // Stack<UndirectedGraphNode> st = new Stack<>();
        // st.push(startNode);
        // //bfs
        // while(!st.isEmpty()){
        //     Stack<UndirectedGraphNode> curSt = new Stack<>();
        //     while(!st.isEmpty()){
        //         UndirectedGraphNode current = st.pop();
        //         UndirectedGraphNode currentClone = map.get(current.label);
        //         for(UndirectedGraphNode neighbor: current.neighbors){
        //             if(map.containsKey(neighbor.label)){
        //                 currentClone.neighbors.add(map.get(neighbor.label));
        //             }else{
        //                 UndirectedGraphNode neighborClone = new UndirectedGraphNode(neighbor.label);
        //                 map.put(neighborClone.label,neighborClone);
        //                 currentClone.neighbors.add(neighborClone);
        //                 curSt.push(neighbor);
        //             }
        //         }
        //     }
        //     st = curSt;
        // }
        // return map.get(start);
        if(node==null) return null;
        Queue<UndirectedGraphNode> que = new LinkedList<>(); // old node
        Map<Integer, UndirectedGraphNode> map = new HashMap<>(); // new node
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(root.label, root);
        que.offer(node);
        UndirectedGraphNode p = root, newRoot = root, newNode = root;
        while(!que.isEmpty()){
            p = que.poll();
            newRoot = map.get(p.label);
            for(UndirectedGraphNode n : p.neighbors){
                if(map.containsKey(n.label)){
                    newNode = map.get(n.label);
                } else{
                    newNode = new UndirectedGraphNode(n.label);
                    map.put(newNode.label, newNode);
                    que.offer(n);
                }
                newRoot.neighbors.add(newNode);
            }
        }
        return root;
    }
}
