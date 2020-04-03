package ch.noseryoung.uk.domainModels.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BidServiceImpl implements BidService{

    private BidRepository bidRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public List<Bid> getAllBids() {
        List<Bid> bidList = bidRepository.findAll();
        return bidList;
    }

    @Override
    public Bid getBidById(String id) {
        return findAllThrow(bidRepository.findById(id));
    }

    @Override
    public Bid createNewBid(Bid bid) {
        bidRepository.save(bid);
        return bid;
    }

    @Override
    public Bid updateBid(Bid bid, String id) {
        findAllThrow(bidRepository.findById(id));
        bid.setId(id);
        bidRepository.save(bid);
        return bid;
    }

    @Override
    public Bid deleteOneBid(String id) {
        bidRepository.deleteById(id);
        return null;
    }

    private Bid findAllThrow(Optional<Bid> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }
}
