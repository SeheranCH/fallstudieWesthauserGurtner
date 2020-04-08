package ch.course223.helloworldIvo.domainModells.auction;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, String> {

    // This is an example query, it isn't actually used
    // It exists to show the basic syntax of the generated queries

}