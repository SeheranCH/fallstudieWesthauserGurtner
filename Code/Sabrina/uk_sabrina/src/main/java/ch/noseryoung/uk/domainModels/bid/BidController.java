package ch.noseryoung.uk.domainModels.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    private BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<Bid>> getAll(){
        return new ResponseEntity<>(bidService.getAllBids(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Bid> getById(@PathVariable String id){
        return new ResponseEntity<>(bidService.getBidById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<Bid> create(@RequestBody Bid bid){
        return new ResponseEntity<>(bidService.createNewBid(bid), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Bid> update(@RequestBody Bid bid, @PathVariable String id){
        return new ResponseEntity<>(bidService.updateBid(bid, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Bid> delete(@PathVariable String id){
        return new ResponseEntity<>(bidService.deleteOneBid(id), HttpStatus.NO_CONTENT);
    }
}
