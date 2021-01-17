package com.nick.software.link.linkedin.persistence.mapping;

import com.nick.software.link.linkedin.persistence.DTO.AccountDetailDto;
import com.nick.software.link.linkedin.persistence.entity.AccountDetail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountDetailMapper {

    AccountDetailMapper INSTANCE = Mappers.getMapper(AccountDetailMapper.class);

    AccountDetail droToEntity(AccountDetailDto accountDetailDto);

    AccountDetailDto entityToDto(AccountDetail accountDetail);

    List<AccountDetailDto> entityToDto(List<AccountDetail> accountDetails);
}
