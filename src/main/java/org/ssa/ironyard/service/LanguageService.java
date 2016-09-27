package org.ssa.ironyard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ssa.ironyard.dao.LanguageDAO;
import org.ssa.ironyard.model.Language;

@Service
public class LanguageService
{
    final LanguageDAO languageDAO;

    @Autowired
    public LanguageService(LanguageDAO languageDAO)
    {
        this.languageDAO = languageDAO;
    }

    public Language insertLanguage(Language language)
    {
        return languageDAO.insert(language);
    }

    public Language readLanguage(int id)
    {
        return languageDAO.read(id);
    }

    // TODO
    
    // public Language updateLanguage(Language language){
    // return languageDAO.update(language);
    // }
    //
    // public boolean deleteLanguage(int id){
    // return languageDAO.delete(id);
    // }
}