package net.kraklups.photonwell.model.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.kraklups.photonwell.util.SeqAlarmException;

@Service
public class SeqAlarmServiceImpl implements SeqAlarmService {

	@Autowired
	private MongoOperations mongo;
	
	@Override
	public long getNextSeqAlarmId(String key) throws SeqAlarmException {
		
		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SeqAlarm seqId = mongo.findAndModify(query, update, options, SeqAlarm.class);

		if (seqId == null) {
			throw new SeqAlarmException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeqAlarm();
	}
}
 