package com.kubekanvas.springbootstarter.Service;


import com.kubekanvas.springbootstarter.Model.KanvasLink;
import com.kubekanvas.springbootstarter.Repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkService {
    @Autowired
    private LinkRepository repository;

    public List<KanvasLink> getAllLinks() {
        return repository.findAll();
    }}
