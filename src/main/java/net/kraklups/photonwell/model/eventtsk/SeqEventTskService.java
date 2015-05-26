package net.kraklups.photonwell.model.eventtsk;

import net.kraklups.photonwell.util.SeqEventTskException;

public interface SeqEventTskService {
	
	long getNextSeqEventTskId(String key) throws SeqEventTskException;

}
