package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.user.User;
import ch.noseryoung.uk.domainModels.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuctionServiceImpl implements AuctionService{

    private AuctionRespository auctionRespository;
    private UserService userService;

    @Autowired
    public AuctionServiceImpl(AuctionRespository auctionRespository, UserService userService) {
        this.auctionRespository = auctionRespository;
        this.userService = userService;
    }


    @Override
    public List<Auction> getAllAuctions() {
        List<Auction> auctionList = auctionRespository.findAll();
        return auctionList;
    }

    @Override
    public Auction getAuctionById(String id) {
        return findAllThrow(auctionRespository.findById(id));
    }

    @Override
    public Auction createNewAuction(Auction auction) {
        auctionRespository.save(auction);
        return auction;
    }

    @Override
    public Auction updateAuction(Auction auction, String id) {
        findAllThrow(auctionRespository.findById(id));
        auction.setId(id);
        auctionRespository.save(auction);
        return auction;
    }

    @Override
    public Auction deleteOneAuction(String id) {
        auctionRespository.deleteById(id);
        return null;
    }

    private Auction findAllThrow(Optional<Auction> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }

    public List<Auction> findAllByUser(int userId){
        List<Auction> auctionList = auctionRespository.findAllByUser(userService.findById(userId));
        return auctionList;
    }

}
