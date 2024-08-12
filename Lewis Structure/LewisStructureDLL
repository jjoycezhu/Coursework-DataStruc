public class LewisStructureDLL {
    private static class Node {

        private char element;               // reference to the element stored at this node
    
        
        private Node north;           
        private Node south;    
        private Node east;   
        private Node west;
        private boolean visited;    
    
        public Node(char e) {
          element = e;
          north = null;
          south = null;
          east = null;
          west = null;
          visited = false;
        }
    
        public char getElement() { return element; }
        public Node getNorth() { return north; }
        public Node getSouth() { return south; }
        public Node getEast() { return east; }
        public Node getWest() {return west; }
        public boolean getVisited() { return visited; }
    
        public void setNorth(Node n) { north = n; }
        public void setSouth(Node s) { south = s; }
        public void setEast(Node e) { east = e; }
        public void setWest(Node w) { west = w; }
        public void setVisited(boolean v) { visited = v; }
      } 

      private Node root;
      private Node position; 

      public LewisStructureDLL(char letter) {
        Node currNode = new Node(letter);
        this.root = currNode;
        this.position = currNode;
      }

      public void add(char letter, String direction) {
        Node newNode = new Node(letter);
        if (direction.equals("North")) {
            position.setNorth(newNode);
            newNode.setSouth(position);
        }
        else if (direction.equals("South")) {
            position.setSouth(newNode);
            newNode.setNorth(position);
        }
        else if (direction.equals("East")) {
            position.setEast(newNode);
            newNode.setWest(position);
        }
        else if (direction.equals("West")) {
            position.setWest(newNode);
            newNode.setEast(position);
        }
        position = newNode;
      }

      public void move(String direction) {
        if (direction.equals("North")) {
            position = position.getNorth();
        }
        else if (direction.equals("South")) {
            position = position.getSouth();
        }
        else if (direction.equals("East")) {
            position = position.getEast();
        }
        else if (direction.equals("West")) {
            position = position.getWest();
        }
      }

      public void print() {
        traverse(root);
        System.out.println();
      }

      private void traverse (Node start) {
        if (start == null || start.getVisited() == true) {
            return;
        }
        else {
            System.out.print(start.getElement() + " ");
            start.setVisited(true);

            if (start.getNorth() != null) {
                traverse(start.getNorth());
            }
            if (start.getSouth() != null) {
                traverse(start.getSouth());
            }
            if (start.getEast() != null) {
                traverse(start.getEast());
            }
            if (start.getWest() != null) {
                traverse(start.getWest());
            }
        }
      }

      
}
