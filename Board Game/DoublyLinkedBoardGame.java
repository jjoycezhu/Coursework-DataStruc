import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class DoublyLinkedBoardGame {
    private static class Node {
      private int element; // reference to the element stored at this node 
      private List<Player> playerOccupied;
      private  Node prev; // reference to the previous node in the list 
      private Node next; // reference to the subsequent node in the list 

      public Node(int e, Node p, Node n) {
        element = e; 
        prev = p; 
        next = n;
        playerOccupied = new ArrayList<>();
      }
       
      public int getElement() { 
        return element; 
      } 
      public Node getPrev() { 
        return prev; 
      } 
      public Node getNext() { 
        return next; 
      } 
      public List<Player> getPlayer() {
        return playerOccupied;
      }
      public void setPrev(Node p) { 
        prev = p; 
      } 
      public void setNext(Node n) { 
        next = n; 
      }
      public void setPlayer(List<Player> p) {
        playerOccupied = p;
      }
      public void addPlayer(Player p) {
        playerOccupied.add(p);
      }
      public void removePlayer(Player p) {
        playerOccupied.remove(p);
      }
    }

    //player class
    public class Player {
    private String playerName;
    private int playerScore;
    private Node currNode;
    private int numTurns;

    public Player (String name) {
        playerName = name;
        playerScore = 0;
        currNode = header;
        numTurns = 0;
    }

    //SETTERS
    public void setName (String name) {
      playerName = name;
    }
    public void setScore (int s) {
      playerScore = s;
    }
    public void setcurrNode(Node n) {
      currNode = n;
    }
    public void setNumTurns(int t) {
      numTurns = t;
    }
    //GETTERS
    public String getName () {
      return playerName;
    }
    public int getScore () {
      return playerScore;
    }
    public Node getcurrNode() {
      return currNode;
    }
    public int getnumTurns() {
      return numTurns;
    }
    //add turns or score
    public int addnumTurns() {
      return numTurns++;
    }
    public void addScore (int a) {
      playerScore += a;
    }

    public void reset () {
      if (currNode != null) {
        currNode.removePlayer(this);
    }
      playerScore = 0;
      currNode = header;
      numTurns = 0;
    }

  }

    //instance vars of list
    private Node header;
    private Node trailer;
    private int size = 0;

    //Constructor
    public DoublyLinkedBoardGame() {
     header = new Node(0, null, null);
     trailer = new Node(0, header, null);
     header.setNext(trailer);
   }

   public void reset() {
    Node current = header;
        while (current != null) {
            current.getPlayer().clear();
            current = current.getNext();
        }
   }

   public int size() {
    return size;
   }

   public boolean isEmpty() {
    return size == 0;
   }

   public void createBoard(int[] values) {
    for (int n : values) {
      addBetween(n, trailer.getPrev(), trailer);
    }
   }

   private void addBetween(int e, Node predecessor, Node successor) {
    Node newest = new Node(e, predecessor, successor); 
    predecessor.setNext(newest);
    successor.setPrev(newest);
    size++;
   }


   public Player playGame(Player[] total) {
    Random rand = new Random();
    boolean gameOver = false;
    Player winner = null;
    
    //play while no one has reached the end
   while (!gameOver) {
      for (Player p : total) {
        Node playerPos = p.getcurrNode();
        Node temp = p.getcurrNode();
        int steps = rand.nextInt(6) + 1;

        p.addnumTurns();

        for (int i = 0; i < steps; i++) {
          playerPos = playerPos.getNext();
          
          //end reached enough points, done
          if ((i == steps - 1) && playerPos.equals(trailer) && p.getScore() >= 44) {
            p.setcurrNode(trailer);
            trailer.addPlayer(p);
            trailer.getPrev().getPlayer().remove(p);
            gameOver = true;
            break;
          }
          //end reached, not enough points, back to start
          else if ((i == steps - 1) && playerPos.equals(trailer) && p.getScore() < 44) {
            p.setcurrNode(header);
            header.addPlayer(p);
            playerPos.getPrev().removePlayer(p);
            p.setScore(0);
            break;
          }
          //end passed, lose turn, back to previous spot
          else if (playerPos.equals(trailer) && (i != (steps - 1))) { 
            p.setcurrNode(temp);
            if (!temp.equals(trailer)) {
              playerPos.getPrev().removePlayer(p);
              temp.addPlayer(p);
            }
            break;
          }
          //space occupied
          else if (!playerPos.getPlayer().isEmpty() && (i == (steps - 1))) {
            //boot previous player out
            Player bootedPlayer = playerPos.getPlayer().get(0);
            bootedPlayer.setcurrNode(header);
            bootedPlayer.setScore(0);
            header.addPlayer(bootedPlayer);
            playerPos.removePlayer(bootedPlayer);
            //add current player in
            playerPos.addPlayer(p);
            p.setcurrNode(playerPos);
            playerPos.getPrev().removePlayer(p);

          }
          //space occupied in middle of turn
          else if (!playerPos.getPlayer().isEmpty() && (i != (steps - 1))) {
            p.setcurrNode(playerPos);
            playerPos.getPrev().removePlayer(p);
          }
          //proceed normally
          else {
            playerPos.addPlayer(p);
            p.setcurrNode(playerPos);
            playerPos.getPrev().removePlayer(p);
          }
        }
    
        if (p.getcurrNode() != temp) {
          p.addScore(playerPos.getElement());
        }

        winner = p;

        if (gameOver == true) {
          break;
        }
      }
    }

    return winner;
    
   }

   public void printBoard () {
    Node current = header.getNext();
    int i = 0;

    System.out.print("[Start");
    if (!header.getPlayer().isEmpty()) {
      System.out.print("[");
      for (Player p : header.getPlayer()) {
         System.out.print(p.getName() + ",");
      }
      System.out.print("]]");
    }
    else {
      System.out.print("[ ]]");
    }

    while (current != trailer) {
      if (!current.getPlayer().isEmpty()) {
        System.out.print("[" + current.getPlayer().get(0).getName() + "]");
      }
      else {
        System.out.print("[ ]");
      }
      current = current.getNext();
      i++;
      if (i == 9 || i == 16) {
        System.out.println();
        System.out.print("          ");
      }
    }
    System.out.print("[End");
    if (!trailer.getPlayer().isEmpty()) {
      System.out.println("[" + trailer.getPlayer().get(0).getName() + "]]");
    }
    else {
      System.out.println("[ ]]");
    }
   }
}

