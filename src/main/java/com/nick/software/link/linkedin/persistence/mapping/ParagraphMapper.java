package com.nick.software.link.linkedin.persistence.mapping;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.DTO.article.ParagraphDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.article.Paragraph;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParagraphMapper {

    ParagraphMapper INSTANCE = Mappers.getMapper(ParagraphMapper.class);

    Paragraph dtoToEntity(ParagraphDto paragraphDto);

    ParagraphDto entityToDto(Paragraph paragraph);
}
