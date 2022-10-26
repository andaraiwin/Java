public class Main {

    public static void nodePriorityTest() {

        Node nodeA = new Node();
        Node nodeB = new Node();

        nodeA.price = 30;
        nodeA.timestamp = 1;
        nodeA.isMinHeap = true;
        nodeB.price = 20;
        nodeB.timestamp = 2;
        nodeB.isMinHeap = true;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));

        nodeA.price = 30;
        nodeA.timestamp = 1;
        nodeA.isMinHeap = false;
        nodeB.price = 20;
        nodeB.timestamp = 2;
        nodeB.isMinHeap = false;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));

        nodeA.price = 100;
        nodeA.timestamp = 1;
        nodeA.isMinHeap = true;
        nodeB.price = 100;
        nodeB.timestamp = 2;
        nodeB.isMinHeap = true;
        System.out.println("nodeA.compare(nodeB) = " + nodeA.compare(nodeB));
        System.out.println("nodeB.compare(nodeA) = " + nodeB.compare(nodeA));

    }

    public static void main(String[] args) {

        // nodePriorityTest();

        StockMarket market = new StockMarket(10, 10); // 10 investos, 10 stocks
        // Add 10 investors and the initial balance
        market.addInvestor("Jedsadakorn", 10000); // ID=0
        market.addInvestor("Charnchol", 10000); // ID=1
        market.addInvestor("Thanapat", 10000); // ID=2
        market.addInvestor("Natthaphong", 9000); // ID=3
        market.addInvestor("Setsiri", 9000); // ID=4
        market.addInvestor("Jirapat", 9000); // ID=5
        market.addInvestor("Atipat", 8000); // ID=6
        market.addInvestor("Phanuwat", 8000); // ID=7
        market.addInvestor("Panyapat", 8000); // ID=8
        market.addInvestor("Nuttadon", 8000); // ID=9
        // Add 10 stocks and the initial price
        market.addStock("PTT", 344);
        market.addStock("CPALL", 60.5);
        market.addStock("SCB", 144);
        market.addStock("KBANK", 170);
        market.addStock("CPF", 27.75);
        market.addStock("TRUE", 7.15);
        market.addStock("CPN", 53);
        market.addStock("BTS", 8.35);
        market.addStock("DTAC", 35.50);
        market.addStock("LH", 8.75);

        // market.giveMeSomeShares();
        market.loadAssets(); // load saved assets
        market.showStockOwnership();

        market.portfolio("Charnchol");
        market.portfolio("Jedsadakorn");

        // To uncomment below, you need to implement Heap
        /*
         * market.submitSellOrder("Thanapat", "SCB", 5, 200);
         * market.submitSellOrder("Atipat", "SCB", 10, 180);
         * market.quote("SCB");
         * 
         * market.submitBuyOrder("Natthaphong", "SCB", 6, 250);
         * market.submitBuyOrder("Setsiri", "SCB", 6, 250);
         * 
         * market.portfolio("Natthaphong");
         * market.portfolio("Setsiri");
         * market.portfolio("Thanapat");
         * market.portfolio("Atipat");
         * 
         * market.quote("KBANK");
         * 
         * market.submitBuyOrder("Jirapat", "KBANK", 2, 90);
         * market.quote("KBANK");
         * 
         * market.submitBuyOrder("Atipat", "KBANK", 1, 85);
         * market.quote("KBANK");
         * market.submitBuyOrder("Phanuwat", "KBANK", 3, 90);
         * market.quote("KBANK");
         * market.submitBuyOrder("Panyapat", "KBANK", 2, 100);
         * market.quote("KBANK");
         * market.submitBuyOrder("Nuttadon", "KBANK", 2, 80);
         * market.quote("KBANK");
         * 
         * 
         * market.submitSellOrder("Natthaphong", "KBANK", 2, 150);
         * market.quote("KBANK");
         * 
         * market.portfolio("Natthaphong");
         * market.submitSellOrder("Natthaphong", "KBANK", 6, 85);
         * 
         * market.portfolio("Natthaphong");
         * 
         * 
         * market.showStockOwnership();
         * 
         * market.submitSellOrder("Jedsadakorn", "PTT", 3, 350);
         * market.submitSellOrder("Jedsadakorn", "PTT", 3, 360);
         * market.submitSellOrder("Jedsadakorn", "PTT", 4, 370);
         * market.submitSellOrder("Thanapat", "PTT", 5, 355);
         * market.submitSellOrder("Thanapat", "PTT", 5, 365);
         * market.submitSellOrder("Thanapat", "PTT", 5, 375);
         * market.submitSellOrder("Setsiri", "PTT", 3, 360);
         * market.submitSellOrder("Setsiri", "PTT", 3, 370);
         * market.submitSellOrder("Setsiri", "PTT", 4, 380);
         * 
         * market.submitBuyOrder("Charnchol", "PTT", 6, 370);
         * market.submitBuyOrder("Natthaphong", "PTT", 6, 370);
         * market.submitBuyOrder("Jirapat", "PTT", 10, 370);
         * market.submitBuyOrder("Atipat", "PTT", 10, 370);
         * 
         * market.submitBuyOrder("Phanuwat", "PTT", 2, 330);
         * market.submitBuyOrder("Phanuwat", "PTT", 2, 300);
         * market.submitBuyOrder("Phanuwat", "PTT", 2, 270);
         * 
         * market.submitBuyOrder("Panyapat", "PTT", 3, 330);
         * market.submitBuyOrder("Panyapat", "PTT", 3, 250);
         * market.submitBuyOrder("Panyapat", "PTT", 3, 200);
         * 
         * market.submitSellOrder("Nuttadon", "PTT", 3, 320);
         * market.submitSellOrder("Nuttadon", "PTT", 3, 240);
         * market.submitSellOrder("Nuttadon", "PTT", 4, 220);
         * market.submitSellOrder("Charnchol", "PTT", 3, 320);
         * market.submitSellOrder("Charnchol", "PTT", 3, 240);
         * market.submitSellOrder("Charnchol", "PTT", 4, 220);
         * 
         * market.quote("PTT");
         * 
         * market.showStockOwnership();
         * 
         * market.portfolio("Charnchol");
         * 
         * market.submitBuyOrder("Jedsadakorn", "PTT", 20, 150);
         * market.submitBuyOrder("Jedsadakorn", "PTT", 20, 100);
         * market.submitBuyOrder("Jedsadakorn", "PTT", 10, 50);
         * 
         * market.submitSellOrder("Jirapat", "PTT", 10, 125);
         * market.submitSellOrder("Atipat", "PTT", 10, 75);
         * market.submitSellOrder("Phanuwat", "PTT", 15, 75);
         * market.submitSellOrder("Panyapat", "PTT", 15, 75);
         * 
         * market.quote("PTT");
         * 
         * market.portfolio("Charnchol");
         * 
         * 
         */
    }

}
