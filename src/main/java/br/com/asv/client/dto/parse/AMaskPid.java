package br.com.asv.client.dto.parse;

import java.io.Serializable;

import br.com.asv.base.model.parse.IMaskPid;


public abstract class AMaskPid<M,I extends Serializable, O extends Serializable> implements IMaskPid<I, O>{

	public abstract byte[] getIdMaskKey();
	
	public abstract M getIdMask();
}
