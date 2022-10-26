package hw4;

public class Stock {
    private List list;
    private int totalShares;

    /*
     * This is constructor use to initialize Stock class and configure buy/sell
     * method for optimal data structure
     */
    public Stock(String costBasis) {
        switch (costBasis) {
            case "FIFO": // aka. first-in-first-out
                list = new Queue(); // we use queue that mean what we buy oldest will sell first
                break;
            case "LIFO": // aka. last-in-first-out
                list = new Stack(); // we use stack that mean what we buy latest will sell first
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }

    /*
     * This method use to record that we buy the shares
     * by create a new node that record amount and price of shares that we buy
     */
    public void buy(int boughtShares, double boughtPrice) {
        Node node = new Node(boughtShares, boughtPrice);
        list.push(node);
        totalShares += boughtShares;
    }

    /*
     * This method use to record that had sold the shares and calculated gain both
     * realized and unrealized
     */
    public void sell(int soldShares, double soldPrice) {
        if (soldShares <= totalShares) { // check wheter we over-sold or not if yes then we shall not continue
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;

            Node current = list.top();
            while (current != null) { // we want calculate all the gain both realized and unrealized which means we
                                      // need to iterate every share we had and perform a calculation from it
                if (soldShares == 0) { // if we already complete a sell transaction then we just calculate unrealized
                                       // gain
                    unrealizedGain += (soldPrice - current.price) * current.shares;
                    current = current.next;
                } else if (soldShares >= current.shares) { // if we had a shares that aren't much enough complete a sell
                                                           // transaction then we just remove it and calculate realized
                                                           // gain
                    soldShares -= current.shares;
                    realizedGain += (soldPrice - current.price) * current.shares;
                    list.pop();
                    current = list.top();
                } else { // but when we had a shares that enough to complete a sell transaction then just
                         // deduct some part of it and calculate realized gain
                    current.shares -= soldShares;
                    realizedGain += (soldPrice - current.price) * soldShares;
                    soldShares = 0;
                }
            }

            totalShares -= soldShares;
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        } else { // report the error when over-sold
            System.out.println("Sell command rejected");
        }
    }

    /*
     * This method use to visualize the structure of current list
     */
    public void showList() {
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode != null) { // we just iterate till the end of the list
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> "); // and print the data of
                                                                                             // current iterator along
                                                                                             // the way
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}