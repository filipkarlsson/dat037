import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;

    public StockTrade() {
        sellersQueue = new BinHeap<Bid>(null);
        buyersQueue  = new BinHeap<Bid>(null);
    }

    public Transaction placeSellBid(Bid bid) {
        sellersQueue.add(bid);
        return null;
    }

    public Transaction placeBuyBid(Bid bid) { return null; }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}
