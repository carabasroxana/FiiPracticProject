package com.fiipractic;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

public class RequestHistorycontroller {

    @RestController
    @RequestMapping("/api/request-history")
    public class RequestHistoryController {

        private final RequestHistoryService requestHistoryService;

        public RequestHistoryController(RequestHistoryService requestHistoryService) {
            this.requestHistoryService = requestHistoryService;
        }

        @PostMapping
        public RequestHistoryEntity createRequestHistory(@RequestBody RequestHistoryEntity requestHistoryEntity) {
            return requestHistoryService.saveRequestHistoryEntity(requestHistoryEntity);
        }

        @GetMapping
        public Page<RequestHistoryEntity> getAllRequestHistory(
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {
            return requestHistoryService.getAllRequestHistory(page, size);
        }
    }

}
