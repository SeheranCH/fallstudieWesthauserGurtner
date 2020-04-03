package ch.noseryoung.uk.domainModels.auction.dto;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface AuctionMapper {

    Auction fromDTO(AuctionDTO dto);
    List<Auction> fromDTOs(List<AuctionDTO> dtos);

    AuctionDTO toDTO(Auction dm);
    List<AuctionDTO> toDTOs(List<Auction> dms);
}
