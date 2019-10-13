package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
    Board findOneById(Long Id);

}
