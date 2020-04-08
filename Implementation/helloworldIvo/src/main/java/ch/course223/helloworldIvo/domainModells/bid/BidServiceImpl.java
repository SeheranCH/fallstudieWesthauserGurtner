package ch.course223.helloworldIvo.domainModells.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BidServiceImpl implements BidService {

    private BidRepository bidRepository;

    @Autowired
    public BidServiceImpl(BidRepository bidRepository) { this.bidRepository = bidRepository; }

    // The logic for creating a new bid
    @Override
    public Bid create(Bid bid) {
        return bidRepository.save(bid);
    }

    // The logic for retrieving all bids
    @Override
    public List<Bid> findAll() {
        return bidRepository.findAll();
    }

    // The logic for retrieving a single bid with a given id
    @Override
    public Bid findById(String id) {
        return bidRepository.findById(id).get();
    }

    // The logic for updating an existing bid with a given id and data
    @Override
    public Bid updateById(String id, Bid bid) {
        if(bidRepository.existsById(id)) {
            bid.setId(id);
            bidRepository.save(bid);
            return bid;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting a bid with a given id
    @Override
    public void deleteById(String id) {
        bidRepository.deleteById(id);
    }
}
