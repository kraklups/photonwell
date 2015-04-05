package net.kraklups.photonwell.model.alarm;

import net.kraklups.photonwell.util.SeqAlarmException;

public interface SeqAlarmService {

	long getNextSeqAlarmId(String key) throws SeqAlarmException;
	
}