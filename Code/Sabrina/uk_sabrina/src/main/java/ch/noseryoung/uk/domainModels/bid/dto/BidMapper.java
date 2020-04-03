package ch.noseryoung.uk.domainModels.bid.dto;

import ch.noseryoung.uk.domainModels.bid.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface BidMapper {

    Bid fromDTO(BidDTO dto);
    List<Bid> fromDTOs(List<Bid> dtos);
    BidDTO toDTO (Bid dm);
    List<BidDTO> toDTOs (List<Bid> dms);
}
