/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    
    int maxAry(Node root){
        if(root == null){
            return 0;
        }
        
        if(root.children != null){
            int ary = root.children.size();
            for(Node child: root.children){
                ary = Math.max(ary, maxAry(child));
            }
            return ary;
        } else {
            return 0;
        }
    }
    
    void doSerialize(Node node, StringBuilder sb){
        if(node == null){
            return;
        }
        sb.append(node.val);
        sb.append(":");
        sb.append("{");
        if(node.children != null){
            for(Node child : node.children){
                doSerialize(child, sb);
            }
        }
        sb.append("}");
    }
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        doSerialize(root, sb);
        return sb.toString();        
    }
	
    int indexOf(char[] data, int startIndex, char target){
        for(int i = startIndex; i<data.length; i++){
            if(data[i] == target){
                return i;
            }            
        }
        return -1;
    }
    
    Node doDeserialize(char[] data, int start, int []next){
        int numberEndIndex = indexOf(data, start, ':');
        int value = Integer.parseInt(new String(data, start, numberEndIndex - start));
        Node  node = new Node(value, new ArrayList<Node>());
        next[0] = numberEndIndex + 3;
        if(data[numberEndIndex + 2] != '}') {        
            int nextStart = next[0] - 1;
            while(data[nextStart] != '}'){
                int end[] = new int[1];
                Node child = doDeserialize(data, nextStart, end);
                node.children.add(child);
                nextStart = end[0];
            }
            next[0] = nextStart + 1;
        }         
        return node;        
    }
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        
        char[] arr = data.toCharArray();
        int[] end = new int[1];
        return doDeserialize(arr, 0, end);        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
