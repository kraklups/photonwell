package net.kraklups.photonwell.model.datavalue;

import net.kraklups.photonwell.util.SeqDataValueException;

public interface SeqDataValueService {

	long getNextSeqDataValueId(String key) throws SeqDataValueException;
	
}
