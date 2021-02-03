package io.covid19vms.service;

import io.covid19vms.entity.DistrictUserRequest;
import io.covid19vms.repository.DistrictUserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictUserRequestServiceImpl implements DistrictUserRequestService {
    @Autowired
    private DistrictUserRequestRepository requestRepo;

    @Override
    public List<DistrictUserRequest> getRequestList(int districtId) {
        return requestRepo.getRequestedUsers(districtId);
    }

	@Override
	public DistrictUserRequest saveDistrictUserRequest(DistrictUserRequest districtUserRequest) {
		return requestRepo.save(districtUserRequest);
	}
}
