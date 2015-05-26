package net.kraklups.photonwell.model.eventtsk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.kraklups.photonwell.util.SeqEventTskException;

@Service
public class SeqEventTskServiceImpl implements SeqEventTskService {

	@Autowired
	private MongoOperations mongo;
	
	@Override
	public long getNextSeqEventTskId(String key) throws SeqEventTskException {
		
		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SeqEventTsk seqId = mongo.findAndModify(query, update, options, SeqEventTsk.class);

		if (seqId == null) {
			throw new SeqEventTskException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeqEventTsk();
	}
}
 