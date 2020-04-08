package ch.course223.helloworldIvo.domainModells.auction;

import ch.course223.helloworldIvo.domainModells.auction.dto.AuctionDTO;
import ch.course223.helloworldIvo.domainModells.auction.dto.AuctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    // The newly created service to be injected
    private AuctionService auctionService;

    // The mapper to be injected
    private AuctionMapper auctionMapper;

    // Injecting the dependency via constructor
    @Autowired
    public AuctionController (AuctionService auctionService, AuctionMapper auctionMapper) {
        this.auctionService = auctionService;
        this.auctionMapper = auctionMapper;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<AuctionDTO> create(@RequestBody AuctionDTO auctionDTO) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.create(auctionMapper.fromDTO(auctionDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<AuctionDTO>> getAll() {
        return new ResponseEntity<>(auctionMapper.toDTOs(auctionService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single auction by its id
    @GetMapping("/{id}")
    public ResponseEntity<AuctionDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.findById(id)), HttpStatus.OK);
    }

    //This endpoint updates an existing auction with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<AuctionDTO> updateById(@PathVariable String id, @RequestBody AuctionDTO auctionDTO) {
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.updateById(id, auctionMapper.fromDTO(auctionDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing auction with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        auctionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
