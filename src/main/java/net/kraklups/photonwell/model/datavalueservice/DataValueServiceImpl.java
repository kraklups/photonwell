package net.kraklups.photonwell.model.datavalueservice;

import java.util.List;

import net.kraklups.photonwell.model.datavalue.DataValueDTO;

import org.springframework.stereotype.Service;

@Service
final class DataValueServiceImpl  implements DataValueService {

	private final DataValueRepository repository;
	
	public DataValueServiceImpl(DataValueRepository repository) {
		this.repository = repository;
	}

	@Override
	public DataValueDTO create(DataValueDTO dataValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataValueDTO delete(String dataValueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataValueDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataValueDTO findBy(String dataValueId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataValueDTO update(DataValueDTO dataValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
