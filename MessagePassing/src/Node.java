public class Node {
    private boolean hasMessage;
    private int coordX;
    private int coordY;
    private Message mess;

    public Node(int x, int y, boolean mess)
    {
        hasMessage = mess;
        coordX = x;
        coordY = y;
    }
    public Message getMessage()
    {
        return mess;
    }
    public void setMessage(Message m)
    {
        mess = m;
    }
    public boolean ReceiveMessage()
    {
        hasMessage = true;
        return hasMessage;
    }

    public boolean getHasMessage()
    {
        return hasMessage;
    }

    public int getCoordX()
    {
        return coordX;
    }
    public int getCoordY()
    {
        return coordY;
    }

    public boolean HandOff(Message m, Node n)
    {
        boolean success = false;
        if(Dist(n) < 6.5 && hasMessage==true)
        {
            if(n.getHasMessage() == false)
            {
                n.ReceiveMessage();
                n.setMessage(m);
                System.out.println();
                success = true;
                System.out.println("Message passed.");
            }
            else
            {
                System.out.println("Message failed.");
            }

        }
        else
        {
            System.out.println("Message failed");
        }
        return success;
    }

    public void Move(int xi, int yi)
    {
        coordX+=xi;
        coordY+=yi;
    }

    public double Dist(Node n)
    {
        double dist = Math.sqrt((n.getCoordX() - coordX) * (n.getCoordX() - coordX) + (n.getCoordY() - coordY) * (n.getCoordY() - coordY));
        double distAbs = Math.abs(dist);
        return distAbs;
    }
}
