package ch.course223.helloworldIvo.domainModells.authority.dto;

import ch.course223.helloworldIvo.domainModells.authority.Authority;
import ch.course223.helloworldIvo.domainModells.user.User;
import ch.course223.helloworldIvo.domainModells.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

// This is an example interface on how a mapper could be built
// This annotation defines this class as a mapper
@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface AuthorityMapper {

    // This method signature generates a method which maps a DTO to it's representing business object
    Authority fromDTO (AuthorityDTO authorityDTO);

    // This method signature generates a method which maps a business object to it's representative DTO
    AuthorityDTO toDTO (Authority authority);

    // This method signature generates a method which maps a list of DTOs to a list of it's representing business objects
    List<Authority> fromDTOs (List<AuthorityDTO> dtos);

    // This method signature generates a method which maps a list of business objects to a list of it's representative DTOs
    List<AuthorityDTO> toDTOs (List<Authority> authorities);

    // This method signature generates a method which maps a set of DTOs to a set of it's representing business objects
    Set<Authority> fromDTOs (Set<AuthorityDTO> dtos);

    // This method signature generates a method which maps a set of business objects to a set of it's representative DTOs
    Set<AuthorityDTO> toDTOs (Set<Authority> authorities);




}
