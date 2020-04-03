package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.user.User;
import org.hibernate.validator.constraints.EAN;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRespository extends JpaRepository<Auction, String> {

    public List<Auction> findAllByUser(User user);
}
