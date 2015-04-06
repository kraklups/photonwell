package net.kraklups.photonwell.model.datavalue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import net.kraklups.photonwell.util.SeqDataValueException;

@Service
public class SeqDataValueServiceImpl implements SeqDataValueService {

	@Autowired
	private MongoOperations mongo;

	@Override
	public long getNextSeqDataValueId(String key) throws SeqDataValueException {

		Query query = new Query(Criteria.where("_id").is(key));

		Update update = new Update();
		update.inc("seq", 1);

		FindAndModifyOptions options = new FindAndModifyOptions();
		options.returnNew(true);

		SeqDataValue seqId = mongo.findAndModify(query, update, options, SeqDataValue.class);

		if (seqId == null) {
			throw new SeqDataValueException("Unable to get sequence id for key : " + key);
		}

		return seqId.getSeqDataValue();	
		
	}

}
