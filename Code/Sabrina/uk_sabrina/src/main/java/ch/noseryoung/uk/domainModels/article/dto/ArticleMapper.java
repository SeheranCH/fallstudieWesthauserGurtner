package ch.noseryoung.uk.domainModels.article.dto;

import ch.noseryoung.uk.domainModels.article.Article;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy= ReportingPolicy.IGNORE)
public interface ArticleMapper {

    Article fromDTO(ArticleDTO dto);
    List<Article> fromDTOs(List<ArticleDTO> dtos);
    // Set?
    ArticleDTO toDTO(Article dm);
    List<ArticleDTO> toDTOs(List<Article> dms);
    // Set??
}
