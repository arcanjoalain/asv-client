package br.com.asv.client.dto;

import java.util.Date;

import br.com.asv.base.client.dto.IBaseDto;
import br.com.asv.base.model.enums.StatusEntityEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ABaseDto<I> implements IBaseDto<I>{

	private I pid;
	
	private StatusEntityEnum statusEntity;
    
	private Date createdAt;
    
	private Long createUserPid;
    
}
