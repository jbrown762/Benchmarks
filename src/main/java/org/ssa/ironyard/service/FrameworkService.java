package org.ssa.ironyard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssa.ironyard.dao.FrameworkDAO;
import org.ssa.ironyard.model.Framework;

@Service
public class FrameworkService
{

    private final FrameworkDAO frameworkDAO;

    @Autowired
    public FrameworkService(FrameworkDAO frameworkDAO)
    {
        this.frameworkDAO = frameworkDAO;
    }

    public Framework createFramework(Framework benchmark)
    {
        return frameworkDAO.insert(benchmark);
    }

    public Framework readFramework(int id)
    {
        return frameworkDAO.read(id);
    }

    // TODO

    // public Framework updateFramework(Framework benchmark){
    // return frameworkDAO.update(benchmark);
    // }
    //
    // public boolean deleteFramework(int id){
    // return frameworkDAO.delete(id);
    // }
    //
    // public List<Framework> readAllFrameworks() {
    // return frameworkDAO.readAll();
    // }
}