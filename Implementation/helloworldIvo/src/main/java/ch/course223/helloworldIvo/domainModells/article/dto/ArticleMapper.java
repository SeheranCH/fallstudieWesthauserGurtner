package ch.course223.helloworldIvo.domainModells.article.dto;

import ch.course223.helloworldIvo.domainModells.article.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.Set;

// This is an example interface on how a mapper could be built
// This annotation defines this class as a mapper
@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface ArticleMapper {

    // This method signature generates a method which maps a DTO to it's representing business object
    Article fromDTO(ArticleDTO articleDTO);

    // This method signature generates a method which maps a business object to it's representative DTO
    ArticleDTO toDTO(Article article);

    // This method signature generates a method which maps a list of DTOs to a list of it's representing business objects
    List<Article> fromDTOs(List<ArticleDTO> dtos);

    // This method signature generates a method which maps a list of business objects to a list of it's representative DTOs
    List<ArticleDTO> toDTOs(List<Article> articles);

    // This method signature generates a method which maps a set of DTOs to a set of it's representing business objects
    Set<Article> fromDTOs(Set<ArticleDTO> dtos);

    // This method signature generates a method which maps a set of business objects to a set of it's representative DTOs
    Set<ArticleDTO> toDTOs(Set<Article> articles);
}
