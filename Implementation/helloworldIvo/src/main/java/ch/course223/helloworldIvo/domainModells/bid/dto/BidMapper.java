package ch.course223.helloworldIvo.domainModells.bid.dto;

import ch.course223.helloworldIvo.domainModells.bid.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

// This is an example interface on how a mapper could be built
// This annotation defines this class as a mapper
@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface BidMapper {

    // This method signature generates a method which maps a DTO to it's representing business object
    Bid fromDTO(BidDTO dto);

    // This method signature generates a method which maps a business object to it's representative DTO
    BidDTO toDTO(Bid bid);

    // This method signature generates a method which maps a list of DTOs to a list of it's representing business objects
    List<Bid> fromDTOs(List<BidDTO> dtos);

    // This method signature generates a method which maps a list of business objects to a list of it's representative DTOs
    List<BidDTO> toDTOs(List<Bid> dms);

    // This method signature generates a method which maps a set of DTOs to a set of it's representing business objects
    Set<Bid> fromDTOs(Set<BidDTO> dtos);

    // This method signature generates a method which maps a set of business objects to a set of it's representative DTOs
    Set<BidDTO> toDTOs(Set<Bid> dms);

}