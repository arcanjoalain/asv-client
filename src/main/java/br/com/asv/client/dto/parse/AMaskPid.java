package br.com.asv.client.dto.parse;

import java.io.Serializable;

import at.favre.lib.idmask.IdMask;
import br.com.asv.base.model.parse.IMaskPid;


public abstract class AMaskPid<I extends Serializable,O extends Serializable> implements IMaskPid<I, O>{

	public abstract byte[] getIdMaskKey();
	
	public abstract IdMask<I> getIdMask();
}
