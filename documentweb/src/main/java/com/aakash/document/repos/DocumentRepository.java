package com.aakash.document.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aakash.document.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long>{

}
