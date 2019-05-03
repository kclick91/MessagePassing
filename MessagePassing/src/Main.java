import java.util.ArrayList;


public class Main {

    public static void main(String[] args)
    {
        /*Node n = new Node(1,1, true);
        Node ntwo = new Node(1,2, false);
        Message m = new Message("Moon dust.");
        n.HandOff(m, ntwo);
        System.out.println(ntwo.getHasMessage());
        System.out.println(ntwo.getMessage().getMessage());*/
        ArrayList<Node> nodes = new ArrayList<>();


        for(int i = 0; i < 100000; i++)
        {
            if (i == 0)
            {
                nodes.add(new Node(i,i, true));
            }
            else
            {
                nodes.add(new Node(i,i, false));
            }

        }
        int messageCount = 1;
        long start = System.currentTimeMillis();
        long finish = 0;
        nodes.get(0).setMessage(new Message("Moon dust."));

        for(int i = 0; i < 99999; i++)
        {
            nodes.get(i+1).Move(1, 1);
                boolean succ = nodes.get(i).HandOff(new Message("Moon dust."), nodes.get(i + 1));
                if(succ)
                {
                    messageCount = messageCount + 1;
                    if(messageCount == 99999)
                    {
                       finish = System.currentTimeMillis();

                    }
                }



        }
        System.out.println(finish - start);

        for(Node n : nodes)
        {
            //System.out.println(n.getMessage().getMessage());
        }
    }
}
