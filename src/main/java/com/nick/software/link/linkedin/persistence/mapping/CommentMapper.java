package com.nick.software.link.linkedin.persistence.mapping;

import com.nick.software.link.linkedin.persistence.DTO.AccountDto;
import com.nick.software.link.linkedin.persistence.DTO.article.CommentDto;
import com.nick.software.link.linkedin.persistence.entity.Account;
import com.nick.software.link.linkedin.persistence.entity.article.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    Comment dtoToEntity(CommentDto commentDto);

    CommentDto entityToDto(Comment comment);

    List<CommentDto> entityToDto(List<Comment> comment);
}
