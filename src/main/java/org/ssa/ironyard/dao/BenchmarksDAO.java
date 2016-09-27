package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.Benchmark;


public interface BenchmarksDAO
{
    Benchmark insert(Benchmark customer);
    //boolean delete(Benchmark toDelete);
    //Benchmark update(Customer customer);
    Benchmark read(String Language);
    List<Benchmark> readAll();
    //boolean deleteAll();
    void close();
}
