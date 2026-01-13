package com.kubekanvas.springbootstarter.Repository;

import com.kubekanvas.springbootstarter.Model.KanvasLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Repository
public interface LinkRepository extends JpaRepository<KanvasLink, Long> {



}





