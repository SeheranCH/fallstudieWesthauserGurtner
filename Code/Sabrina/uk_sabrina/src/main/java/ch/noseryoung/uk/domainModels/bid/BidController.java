package ch.noseryoung.uk.domainModels.bid;

import ch.noseryoung.uk.domainModels.bid.dto.BidDTO;
import ch.noseryoung.uk.domainModels.bid.dto.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    private BidService bidService;
    private BidMapper bidMapper;

    @Autowired
    public BidController(BidService bidService, BidMapper bidMapper) {
        this.bidService = bidService;
        this.bidMapper = bidMapper;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<BidDTO>> getAll(){
        return new ResponseEntity<>(bidMapper.toDTOs(bidService.getAllBids()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<BidDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(bidMapper.toDTO(bidService.getBidById(id)), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<BidDTO> create(@RequestBody BidDTO bidDTO){
        return new ResponseEntity<>(bidMapper.toDTO(bidService.createNewBid(bidMapper.fromDTO(bidDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<BidDTO> update(@RequestBody BidDTO bidDTO, @PathVariable String id){
        return new ResponseEntity<>(bidMapper.toDTO(bidService.updateBid(bidMapper.fromDTO(bidDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<BidDTO> delete(@PathVariable String id){
        return new ResponseEntity<>(bidMapper.toDTO(bidService.deleteOneBid(id)), HttpStatus.NO_CONTENT);
    }
}
