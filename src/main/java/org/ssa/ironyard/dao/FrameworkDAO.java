package org.ssa.ironyard.dao;

import java.util.List;

import org.ssa.ironyard.model.Framework;

public interface FrameworkDAO
{
    Framework insert(Framework f);
    Framework read(int id);
}
