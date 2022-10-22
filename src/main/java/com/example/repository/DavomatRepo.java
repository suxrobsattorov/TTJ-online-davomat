package com.example.repository;

import com.example.entity.Davomat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Suxrob Sattorov, Thu 8:52 AM. 10/20/2022
 */

@Repository
public interface DavomatRepo extends JpaRepository<Davomat, Long> {

    Davomat findByStudentId( Long id );

}
