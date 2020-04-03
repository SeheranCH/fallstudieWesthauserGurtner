package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.auction.dto.AuctionDTO;
import ch.noseryoung.uk.domainModels.auction.dto.AuctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionService auctionService;
    private AuctionMapper auctionMapper;

    @Autowired
    public AuctionController(AuctionService auctionService, AuctionMapper auctionMapper) {
        this.auctionService = auctionService;
        this.auctionMapper = auctionMapper;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<AuctionDTO>> getAll(){
        return new ResponseEntity<>(auctionMapper.toDTOs(auctionService.getAllAuctions()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<AuctionDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.getAuctionById(id)), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public  @ResponseBody
    ResponseEntity<List<AuctionDTO>> getAllByUserId(@PathVariable int userId){
        return new ResponseEntity<>(auctionMapper.toDTOs(auctionService.findAllByUser(userId)), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<AuctionDTO> create(@RequestBody AuctionDTO auctionDTO){
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.createNewAuction(auctionMapper.fromDTO(auctionDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<AuctionDTO> update(@RequestBody AuctionDTO auctionDTO, @PathVariable String id){
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.updateAuction(auctionMapper.fromDTO(auctionDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<AuctionDTO> delete(@PathVariable String id){
        return new ResponseEntity<>(auctionMapper.toDTO(auctionService.deleteOneAuction(id)), HttpStatus.NO_CONTENT);
    }
}
