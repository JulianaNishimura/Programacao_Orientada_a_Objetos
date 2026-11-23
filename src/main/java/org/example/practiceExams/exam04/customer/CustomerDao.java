package org.example.practiceExams.exam04.customer;

import java.util.Optional;

public interface CustomerDao {
    void save(CustomerDto dto);
    Optional<CustomerDto> findOne(String plate);
}
