package io.covid19vms.service;

import io.covid19vms.entity.DistrictUserRequest;

import java.util.List;

public interface DistrictUserRequestService {
    List<DistrictUserRequest> getRequestList(int districtId);
    DistrictUserRequest saveDistrictUserRequest(DistrictUserRequest districtUserRequest);
}
