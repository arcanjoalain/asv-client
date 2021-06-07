package br.com.asv.client.dto;

import java.io.Serializable;
import java.util.Date;

import br.com.asv.base.client.dto.IBaseDto;
import br.com.asv.base.model.enums.StatusEntityEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ABaseDto<I extends Serializable> implements IBaseDto<I>{

	private static final long serialVersionUID = 6589232013657216998L;

	private I pid;
	
	private StatusEntityEnum statusEntity;
    
	private Date createdAt;
    
	private Long createUserPid;
    
}
