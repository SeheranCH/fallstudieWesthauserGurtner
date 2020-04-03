package ch.noseryoung.uk.domainModels.auction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<Auction>> getAll(){
        return new ResponseEntity<>(auctionService.getAllAuctions(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Auction> getById(@PathVariable String id){
        return new ResponseEntity<>(auctionService.getAuctionById(id), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public  @ResponseBody
    ResponseEntity<List<Auction>> getAllByUserId(@PathVariable int userId){
        return new ResponseEntity<>(auctionService.findAllByUser(userId), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<Auction> create(@RequestBody Auction auction){
        return new ResponseEntity<>(auctionService.createNewAuction(auction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Auction> update(@RequestBody Auction auction, @PathVariable String id){
        return new ResponseEntity<>(auctionService.updateAuction(auction, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Auction> delete(@PathVariable String id){
        return new ResponseEntity<>(auctionService.deleteOneAuction(id), HttpStatus.NO_CONTENT);
    }
}
