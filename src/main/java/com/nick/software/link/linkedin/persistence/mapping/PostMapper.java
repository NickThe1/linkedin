package com.nick.software.link.linkedin.persistence.mapping;

import com.nick.software.link.linkedin.persistence.DTO.article.PostDto;
import com.nick.software.link.linkedin.persistence.entity.article.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post dtoToEntity(PostDto postDto);

    PostDto entityToDto(Post post);

    List<PostDto> entityToDto(List<Post> post);
}
