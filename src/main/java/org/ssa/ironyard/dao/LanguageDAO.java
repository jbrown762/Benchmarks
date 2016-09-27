package org.ssa.ironyard.dao;

import org.ssa.ironyard.model.Language;

public interface LanguageDAO
{
    Language insert(Language l);
    Language read(int id);
}
