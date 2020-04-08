package ch.course223.helloworldIvo.domainModells.bid;

import ch.course223.helloworldIvo.domainModells.bid.dto.BidDTO;
import ch.course223.helloworldIvo.domainModells.bid.dto.BidMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    // The newly created service to be injected
    private BidService bidService;

    // The mapper to be injected
    private BidMapper bidMapper;

    // Injecting the dependency via constructor
    @Autowired
    public BidController(BidService bidService, BidMapper bidMapper) {
        this.bidService = bidService;
        this.bidMapper = bidMapper;
    }

    // This endpoint crates a new bid with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<BidDTO> create(@RequestBody BidDTO bidDTO) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.create(bidMapper.fromDTO(bidDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all bids as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<BidDTO>> getAll() {
        return new ResponseEntity<>(bidMapper.toDTOs(bidService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single bid by its id
    @GetMapping("/{id}")
    public ResponseEntity<BidDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing auction with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<BidDTO> updateById(@PathVariable String id, @RequestBody BidDTO bidDTO) {
        return new ResponseEntity<>(bidMapper.toDTO(bidService.updateById(id, bidMapper.fromDTO(bidDTO))), HttpStatus.OK);
    }

    // This endpoint deleted an existing bid with id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        bidService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
