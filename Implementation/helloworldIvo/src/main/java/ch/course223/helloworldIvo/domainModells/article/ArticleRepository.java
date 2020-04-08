package ch.course223.helloworldIvo.domainModells.article;

import ch.course223.helloworldIvo.domainModells.auction.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    // This is an example query, it isn't actually used
    // It exists to show the basic syntax of the generated queries

}
