package com.example.securiy1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.securiy1.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long>{

}
