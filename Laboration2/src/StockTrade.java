import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;

    public StockTrade() {
        sellersQueue = new BinHeap<Bid>(new SellComparator());
        buyersQueue  = new BinHeap<Bid>(new BuyComparator());
    }

    public Transaction placeSellBid(Bid bid) {
        sellersQueue.remove(bid); // removes if the bidder already exists.
        sellersQueue.add(bid);
        if (sellersQueue.peek().price <= buyersQueue.peek().price ){
            return new Transaction(sellersQueue.poll().name, buyersQueue.peek().name, buyersQueue.poll().price);
        }
        return null;
    }

    public Transaction placeBuyBid(Bid bid) {
        buyersQueue.remove(bid);
        buyersQueue.add(bid);
        if (sellersQueue.peek().price <= buyersQueue.peek().price){
            return new Transaction(sellersQueue.poll().name, buyersQueue.peek().name, buyersQueue.poll().price);
        }
        return null;
    }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}
