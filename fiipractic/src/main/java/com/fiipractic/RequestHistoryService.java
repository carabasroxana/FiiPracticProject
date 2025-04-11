package com.fiipractic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RequestHistoryService {

    private final RequestHistoryRepo.RequestHistoryRepository requestHistoryRepository;

    public RequestHistoryService(RequestHistoryRepo.RequestHistoryRepository requestHistoryRepository) {
        this.requestHistoryRepository = requestHistoryRepository;
    }

    public RequestHistoryEntity saveRequestHistory(RequestHistoryEntity requestHistory) {
        return requestHistoryRepository.save(requestHistory);
    }

    public Page<RequestHistoryEntity> getAllRequestHistory(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return requestHistoryRepository.findAll(pageable);
    }

    public RequestHistoryEntity getRequestHistory(Long id) {
        return requestHistoryRepository.findById(id).orElse(null);
    }

    public RequestHistoryEntity saveRequestHistoryEntity(RequestHistoryEntity requestHistoryEntity) {
        return requestHistoryEntity;
    }
}
